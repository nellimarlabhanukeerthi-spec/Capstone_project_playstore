package com.playstore.appms.exception;

public class AppNotFoundException extends RuntimeException {
    public AppNotFoundException(String msg) {
        super(msg);
    }
}
