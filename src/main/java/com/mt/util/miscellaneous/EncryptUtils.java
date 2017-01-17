package com.mt.util.miscellaneous;

import com.mt.util.exception.MTBug;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by root on 27/10/16.
 */
public enum EncryptUtils {

    Instance;

    private MessageDigest md5;
    private MessageDigest sha;

    EncryptUtils() {
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException nsaex) {
            throw new MTBug(nsaex.getMessage());
        }
    }

    public String md5(String value) {
        return StringUtils.isEmpty(value) ? "" : md5(value.getBytes());
    }

    public String md5(byte[] value) {
        md5.update(value);
        return String.format("%032x", new BigInteger(1, md5.digest()));
    }

    public String sha(String value) {
        return StringUtils.isEmpty(value) ? "" : sha(value.getBytes());
    }

    public String sha(byte[] value) {
        sha.update(value);
        return String.format("%032x", new BigInteger(1, sha.digest()));
    }


}
