package com.ing.mwchapter;

import com.ing.mwchapter.services.impl.FibonacciServiceImpl;
import com.ing.mwchapter.services.IFibonacciService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class FibonacciServiceTest {

    private IFibonacciService fibonacciService = new FibonacciServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testGetFibonacciNegativePosition() {
        //Given
        int position = -1;

        //When
        fibonacciService.getFibonacciNumber(position);

        //Then
    }

    @Test
    public void testGetFibonacciZeroPosition() {
        //Given
        int position = 0;

        //When
        BigInteger fibonacciNumber = fibonacciService.getFibonacciNumber(position);

        //Then
        Assert.assertEquals(BigInteger.ZERO, fibonacciNumber);
    }

    @Test
    public void testGetFibonacciFirstPosition() {
        //Given
        int position = 1;

        //When
        BigInteger fibonacciNumber = fibonacciService.getFibonacciNumber(position);

        //Then
        Assert.assertEquals(BigInteger.ONE, fibonacciNumber);
    }

    @Test
    public void testGetFibonacciSmallPosition() {
        //Given
        int position = 10;

        //When
        BigInteger fibonacciNumber = fibonacciService.getFibonacciNumber(position);

        //Then
        Assert.assertEquals(BigInteger.valueOf(55), fibonacciNumber);
    }

    @Test
    public void testGetFibonacciNotThatSmallPosition() {
        //Given
        int position = 30;

        //When
        BigInteger fibonacciNumber = fibonacciService.getFibonacciNumber(position);

        //Then
        Assert.assertEquals(BigInteger.valueOf(832040), fibonacciNumber);
    }


    @Test
    public void testGetFibonacciNotThatBigPosition() {
        //Given
        int position = 40;

        //When
        BigInteger fibonacciNumber = fibonacciService.getFibonacciNumber(position);

        //Then
        Assert.assertEquals(BigInteger.valueOf(102334155L), fibonacciNumber);
    }

    @Test
    public void testGetFibonacciNotThatBigPlus5Position() {
        //Given
        int position = 45;

        //When
        BigInteger fibonacciNumber = fibonacciService.getFibonacciNumber(position);

        //Then
        Assert.assertEquals(BigInteger.valueOf(1134903170L), fibonacciNumber);
    }

}
