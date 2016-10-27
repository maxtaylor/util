package com.mt.util.exception;

public final class MTException extends Exception {
    public MTException() {
    }

    public MTException(String s) {
        super(s);
    }

    public MTException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MTException(Throwable throwable) {
        super(throwable);
    }

}
