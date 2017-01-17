package com.mt.util.miscellaneous;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by root on 17/01/17.
 */
public final class CollectionUtilsTest {

    private final CollectionUtils collectionUtils = CollectionUtils.Instance;

    @Test
    public void test_is_empty() {
        assertTrue("empty", collectionUtils.isEmpty(null));
        assertTrue("empty", collectionUtils.isEmpty(Collections.emptyList()));
        assertFalse("not empty", collectionUtils.isEmpty(Arrays.asList("")));
    }

    @Test
    public void test_toString() {
        assertEquals("null", "null", collectionUtils.toString(null));
        assertEquals("[]", "[]", collectionUtils.toString(Arrays.asList()));
        assertEquals("[5, 4, 3, 2, 1]", "[5, 4, 3, 2, 1]", collectionUtils.toString(Arrays.asList(5, 4, 3, 2, 1)));
    }

    @Test
    public void test_is_same() {
        assertTrue("same", collectionUtils.isSame(Arrays.asList(3, 2, 1), Arrays.asList(1, 2, 3)));
        assertTrue("same", collectionUtils.isSame(Arrays.asList(30, 20, 10), Arrays.asList(10, 20, 30)));
        assertFalse("not same", collectionUtils.isSame(Arrays.asList(3, 2, 1), Arrays.asList(2, 3)));
        assertFalse("not same", collectionUtils.isSame(Arrays.asList(3, 2), Arrays.asList(1, 2, 3)));
    }
}
