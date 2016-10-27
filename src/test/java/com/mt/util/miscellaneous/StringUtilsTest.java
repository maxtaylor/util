package com.mt.util.miscellaneous;

import com.mt.util.exception.MTBug;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by root on 27/10/16.
 */
public class StringUtilsTest {

    private static final int DEFAULT_LENGTH = StringUtils.DEFAILT_LENGTH;
    private static final int VERY_BIG_NUMBER = 99 * UUID.randomUUID().toString().replaceAll("-", "").length();

    /**
     * Tests all possible strings as empty or not empty
     */
    @Test
    public void test_string_is_empty() {
        assertTrue("empty", StringUtils.isEmpty(null));
        assertTrue("empty", StringUtils.isEmpty(""));
        assertTrue("empty", StringUtils.isEmpty(" "));
        assertTrue("empty", StringUtils.isEmpty("  "));
        assertFalse("not empty", StringUtils.isEmpty("x"));
        assertFalse("not empty", StringUtils.isEmpty("X"));
        assertFalse("not empty", StringUtils.isEmpty(" Xx "));
    }

    /**
     * Tests random string empty
     */
    @Test
    public void test_random_string_empty() {
        assertEquals("Default length should match", DEFAULT_LENGTH, StringUtils.randomString().length());
    }

    /**
     * Tests random string non empty, valid cases
     */
    @Test
    public void test_random_string_non_empty() {
        assertEquals("length should match", DEFAULT_LENGTH, StringUtils.randomString(null, DEFAULT_LENGTH).length());
        assertEquals("length should match", DEFAULT_LENGTH, StringUtils.randomString("", DEFAULT_LENGTH).length());
        assertEquals("length should match", DEFAULT_LENGTH, StringUtils.randomString(" ", DEFAULT_LENGTH).length());

        final String value0 = StringUtils.randomString("A!£$%^&*()_-+=[]{};:@'~#<>?`¬|z", 20);
        assertTrue("Should start with right char", value0.startsWith("Az" + StringUtils.SPLIT_CHAR));
        assertEquals("length should match", 20, value0.length());

        final String value1 = StringUtils.randomString(" Xx ", 20);
        assertTrue("Should start with right char", value1.startsWith("Xx" + StringUtils.SPLIT_CHAR));
        assertEquals("length should match", 20, value1.length());

        final String value2 = StringUtils.randomString(" Xx ", VERY_BIG_NUMBER);
        assertTrue("Should start with right char", value2.startsWith("Xx" + StringUtils.SPLIT_CHAR));
        assertEquals("length should match", VERY_BIG_NUMBER, value2.length());
    }

    /**
     * Tests random string non empty, too short
     */
    @Test(expected = MTBug.class)
    public void test_random_string_non_empty_bed_length() {
        StringUtils.randomString("", 0);
    }


    @Test(expected = MTBug.class)
    public void test_random_string_non_empty_shorter_than_min_length() {
        StringUtils.randomString("", StringUtils.MIN_DIFFERENCE - 1);
    }

    @Test(expected = MTBug.class)
    public void test_random_string_non_empty_seed_too_long() {
        final String value = UUID.randomUUID().toString().replaceAll("-", "");
        final int valueLen = value.length();
        StringUtils.randomString(value, valueLen + StringUtils.MIN_DIFFERENCE - 1);
    }

}
