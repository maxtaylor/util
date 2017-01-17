package com.mt.util.miscellaneous;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 31/10/16.
 */
public class EncryptUtilsTest {

    private final EncryptUtils eu = EncryptUtils.Instance;
    private final int repeats = 3;

    /**
     * Testing md5 encryption
     */
    @Test
    public void test_md5() {
        final String value = StringUtils.randomString();
        final String md5 = eu.md5(value);
        for (int index = 0; index < repeats; index++) {
            assertEquals("same every time", md5, eu.md5(value));
        }
        assertFalse("not empty", StringUtils.isEmpty(md5));
        assertEquals("length 32", 32, md5.length());
        assertNotEquals("different from before", value, md5);
    }

    /**
     * Testing sha encryption
     */
    @Test
    public void test_sha() {
        final String value = StringUtils.randomString();
        final String sha = eu.sha(value);
        for (int index = 0; index < repeats; index++) {
            assertEquals("same every time", sha, eu.sha(value));
        }
        assertFalse("not empty", StringUtils.isEmpty(sha));
        assertEquals("length 40", 40, sha.length());
        assertNotEquals("different from before", value, sha);
    }
}