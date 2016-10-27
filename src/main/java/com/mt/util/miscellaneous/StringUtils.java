package com.mt.util.miscellaneous;

import com.mt.util.exception.MTBug;

import java.util.UUID;

/**
 * Created by root on 27/10/16.
 * <p>
 * Contains utility methods for String
 */
public final class StringUtils {

    public static final int MIN_DIFFERENCE = 7;
    public static final int DEFAILT_LENGTH = 30;
    public static final String SPLIT_CHAR = "#";

    /**
     * Determine if the String is empty or not
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }

    /**
     * Create a random string of 30 chars
     *
     * @return
     */
    public static String randomString() {
        return randomString("", DEFAILT_LENGTH);
    }

    /**
     * Create a random string of any length with a seed value
     *
     * @param seed
     * @param desiredLength
     * @return
     */
    public static String randomString(String seed, int desiredLength) {

        if (desiredLength < MIN_DIFFERENCE) {
            throw new MTBug(String.format("Desired length [%d] is too short", desiredLength));
        }

        final String theSeed = isEmpty(seed) ? "" : seed.trim().replaceAll("[^A-Za-z0-9]", "");

        if (theSeed.length() > desiredLength - MIN_DIFFERENCE) {
            throw new MTBug(String.format("Seed [%S] is too long for the length [%d] required, collisions likely", theSeed, desiredLength));
        }

        final StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < desiredLength - theSeed.length()) {
            stringBuilder.append(UUID.randomUUID().toString().replaceAll("-", ""));
        }

        return isEmpty(theSeed) ?
                stringBuilder.toString().substring(0, desiredLength) :
                String.format("%s%s%s", theSeed, SPLIT_CHAR, stringBuilder.toString().substring(0, desiredLength - theSeed.length() - SPLIT_CHAR.length()));
    }

}
