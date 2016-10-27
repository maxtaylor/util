package com.mt.util.miscellaneous;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 28/10/16.
 */
public class StringRegexUtilsTest {

    @Test
    public void test_is_alphanumeric() {
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric(null));
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric(""));
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric(" "));
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric("0123456789"));
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric("!£$%^&*()_+-="));
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric("0123456789!£$%^&*()_+-="));
        assertFalse("not Alphanumeric", StringRegexUtils.isAlphanumeric("123-AZaz-£$%^&"));

        assertTrue("Alphanumeric", StringRegexUtils.isAlphanumeric("az"));
        assertTrue("Alphanumeric", StringRegexUtils.isAlphanumeric("AZ"));
        assertTrue("Alphanumeric", StringRegexUtils.isAlphanumeric("AZaz"));
        assertTrue("Alphanumeric", StringRegexUtils.isAlphanumeric("az"));
    }

    @Test
    public void test_is_numbers_only() {
        assertFalse("not numbers only", StringRegexUtils.isNumbersOnly(null));
        assertFalse("not numbers only", StringRegexUtils.isNumbersOnly(""));
        assertFalse("not numbers only", StringRegexUtils.isNumbersOnly(" "));
        assertFalse("not numbers only", StringRegexUtils.isNumbersOnly("£$%"));
        assertFalse("not numbers only", StringRegexUtils.isNumbersOnly("abc"));
        assertFalse("not numbers only", StringRegexUtils.isNumbersOnly("£$%abc123"));

        assertTrue("is a number", StringRegexUtils.isNumbersOnly("1234567890"));
        assertTrue("is a number", StringRegexUtils.isNumbersOnly("0987654321"));
    }
}
