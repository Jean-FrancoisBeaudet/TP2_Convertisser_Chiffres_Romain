package ca.csf.pobj.tp2;

import org.junit.Assert;
import org.junit.Test;

import ca.csf.pobj.tp2.RomanNumberConverter.RomanNumberConverter;

import static org.junit.Assert.*;

public class RomanNumberConverterTest {

    @Test
    public void convert() {
        assertEquals("I", RomanNumberConverter.convert(1));
        assertEquals("II", RomanNumberConverter.convert(2));
        assertEquals("III", RomanNumberConverter.convert(3));
        assertEquals("IV", RomanNumberConverter.convert(4));
        assertEquals("V", RomanNumberConverter.convert(5));
        assertEquals("VI", RomanNumberConverter.convert(6));
        assertEquals("VII", RomanNumberConverter.convert(7));
        assertEquals("VIII", RomanNumberConverter.convert(8));
        assertEquals("IX", RomanNumberConverter.convert(9));
        assertEquals("X", RomanNumberConverter.convert(10));
        assertEquals("XXVII", RomanNumberConverter.convert(27));
        assertEquals("XLI", RomanNumberConverter.convert(41));
        assertEquals("XLIX", RomanNumberConverter.convert(49));
        assertEquals("L", RomanNumberConverter.convert(50));
        assertEquals("XCIX", RomanNumberConverter.convert(99));
        assertEquals("C", RomanNumberConverter.convert(100));
        assertEquals("CDXLIV", RomanNumberConverter.convert(444));
        assertEquals("CDXCIX", RomanNumberConverter.convert(499));
        assertEquals("D", RomanNumberConverter.convert(500));
        assertEquals("DCCXXII", RomanNumberConverter.convert(722));
        assertEquals("CM", RomanNumberConverter.convert(900));
        assertEquals("CMXCIX", RomanNumberConverter.convert(999));
        assertEquals("M", RomanNumberConverter.convert(1000));
        assertEquals("MD", RomanNumberConverter.convert(1500));
        assertEquals("MCMLXXII", RomanNumberConverter.convert(1972));
        assertEquals("MMXVIII", RomanNumberConverter.convert(2018));
        assertEquals("MMMD", RomanNumberConverter.convert(3500));
        assertEquals("MMMMCMXCIX", RomanNumberConverter.convert(4999));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertExceptionTest01() {
        RomanNumberConverter.convert(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertExceptionTest02() {
        RomanNumberConverter.convert(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertExceptionTest03() {
        RomanNumberConverter.convert(5000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertExceptionTest04() {
        RomanNumberConverter.convert(5001);
    }
}