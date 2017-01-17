package com.mt.util.miscellaneous;

/**
 * Created by root on 27/10/16.
 */
public final class StringRegexUtils {

    //todo work in progress

    public static boolean isAlphanumeric(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        return value.equals(value.replaceAll("[^a-zA-Z]", ""));
    }

    public static boolean isNumbersOnly(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        return value.equals(value.replaceAll("[^0-9]", ""));
    }
}
