package com.ing.mwchapter;

import com.ing.mwchapter.services.IKeyboardService;
import com.ing.mwchapter.services.impl.KeyboardServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class KeyboardServiceTest {

    private IKeyboardService keyboardService = new KeyboardServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void emptyCodeTest() {
        //Given
        String code = "";
        String keypad = "123456789";

        //When
        keyboardService.entryTime(code, keypad);

        //Then

    }

    @Test(expected = IllegalArgumentException.class)
    public void codeWithLettersTest() {
        //Given
        String code = "12a3";
        String keypad = "123456789";

        //When
        keyboardService.entryTime(code, keypad);

        //Then

    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyKeypad() {
        //Given
        String code = "123";
        String keypad = "";

        //When
        keyboardService.entryTime(code, keypad);

        //Then

    }

    @Test(expected = IllegalArgumentException.class)
    public void keypadWithLetter() {
        //Given
        String code = "123";
        String keypad = "";

        //When
        keyboardService.entryTime(code, keypad);

        //Then

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidKeypadLength() {
        //Given
        String code = "123";
        String keypad = "1234567890";

        //When
        keyboardService.entryTime(code, keypad);

        //Then

    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidKeypadContent() {
        //Given
        String code = "123";
        String keypad = "123456788";

        //When
        keyboardService.entryTime(code, keypad);

        //Then

    }

    @Test
    public void firstTest() {
        //Given
        String code = "423692";
        String keypad = "923857614";

        //When
        int result = keyboardService.entryTime(code, keypad);

        //Then
        Assert.assertEquals(8, result);
    }

    @Test
    public void secondTest() {
        //Given
        String code = "5111";
        String keypad = "752961348";

        //When
        int result = keyboardService.entryTime(code, keypad);

        //Then
        Assert.assertEquals(1, result);
    }

}
