package com.mt.util.exception;

/**
 * Created by root on 27/10/16.
 */
public final class MTBug extends RuntimeException {
    public MTBug() {
    }

    public MTBug(String s) {
        super(s);
    }

    public MTBug(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MTBug(Throwable throwable) {
        super(throwable);
    }
}
