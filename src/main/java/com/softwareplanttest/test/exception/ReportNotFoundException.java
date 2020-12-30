package com.softwareplanttest.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "report not found")
public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(long reportId) {
        super("Unable to find report id: " + reportId);
    }
}
