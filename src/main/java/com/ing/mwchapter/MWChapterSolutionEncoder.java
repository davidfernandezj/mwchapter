package com.ing.mwchapter;

import lombok.Getter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MWChapterSolutionEncoder {

	private static final byte[] SALT = {41, 74, -31, 113, -25, 85, 65, -69};
	private static final int KEY_DERIVATION_ITERATION = 65536;
	private static final int KEY_SIZE = 256;
	private static final String ALGORITHM = "AES";

	public static void main(String[] args) {

		if(args.length != 2 || !Operation.getOperation(args[0]).isPresent()) {
			System.err.println("Two parameters are required:\n" +
					" 1st: 'encode' or 'decode'\n" +
					" 2nd: secret key");
			return;
		}

		Operation operation = Operation.getOperation(args[0]).get();
		try{
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			SecretKey secretKey = getSecretKey(args[1]);
			operation.getOperation().accept(cipher, secretKey);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void encodeFiles(Cipher cipher, SecretKey secretKey) {
		try{
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			for(SecretResource resource: SecretResource.values()) {
				encodeFile(resource, cipher);
			}
		}catch (Exception e) {
			System.err.println("Error encoding files");
			e.printStackTrace();
		}
	}

	private static void encodeFile(SecretResource resource, Cipher cipher) throws IOException, BadPaddingException, IllegalBlockSizeException {
		Path fileToEncode = Paths.get(resource.getPlain());
		byte[] fileBytes = readFileBytes(fileToEncode);
		byte[] encryptedBytes = cipher.doFinal(fileBytes);
		writeFileBytes(resource.getEncoded(), encryptedBytes);
		Files.delete(fileToEncode);

	}

	private static void decodeFile(SecretResource resource, Cipher cipher) throws IOException, BadPaddingException, IllegalBlockSizeException {
		Path fileToDecode = Paths.get(resource.getEncoded());
		byte[] fileBytes = readFileBytes(fileToDecode);
		byte[] decodedBytes = cipher.doFinal(fileBytes);
		writeFileBytes(resource.getPlain(), decodedBytes);
		Files.delete(fileToDecode);
	}

	private static void decodeFiles(Cipher cipher, SecretKey secretKey) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			for(SecretResource resource: SecretResource.values()) {
				decodeFile(resource, cipher);
			}
		} catch (Exception e) {
			System.err.println("Error decoding files");
			e.printStackTrace();
		}
	}

	private static byte[] readFileBytes(Path path) throws IOException {
		return Files.readAllBytes(path);
	}

	private static void writeFileBytes(String filePath, byte[] content) throws IOException {
		Path path = Paths.get(filePath);
		Files.write(path, content);
	}

	private static SecretKey getSecretKey(String stringSecret) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(stringSecret.toCharArray(), SALT, KEY_DERIVATION_ITERATION, KEY_SIZE);
		SecretKey tmp = factory.generateSecret(spec);
		return new SecretKeySpec(tmp.getEncoded(), ALGORITHM);
	}

	private enum Operation {
		ENCODE("encode", MWChapterSolutionEncoder::encodeFiles),
		DECODE("decode", MWChapterSolutionEncoder::decodeFiles);

		private final String code;
		@Getter
		private final BiConsumer<Cipher, SecretKey> operation;

		Operation(String code, BiConsumer<Cipher, SecretKey> operation) {
			this.code = code;
			this.operation = operation;
		}

		public static Optional<Operation> getOperation(String code) {
			return Stream.of(Operation.values())
					.filter(operation -> operation.code.equalsIgnoreCase(code))
					.findAny();
		}

	}

	@Getter
	private enum SecretResource {
		KEYBOARD("src/main/java/com/ing/mwchapter/services/impl/KeyboardServiceProposalImpl.java",
				"src/main/java/com/ing/mwchapter/services/impl/KeyboardServiceProposalImpl.encoded");

		private final String plain;
		private final String encoded;

		SecretResource(String plain, String encoded) {
			this.plain = plain;
			this.encoded = encoded;
		}
	}

}
