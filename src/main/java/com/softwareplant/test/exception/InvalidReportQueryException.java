package com.softwareplant.test.exception;

public class InvalidReportQueryException extends RuntimeException {
    public InvalidReportQueryException(String message) {
        super(message);
    }
}
