package com.copious.restAPI.RestApi.Exceptions;

import com.copious.restAPI.RestApi.Constants.ExceptionCode;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException
{
    private final ExceptionCode exceptionCode;

    private final String errorDetails;

    public UserNotFoundException(ExceptionCode exceptionCode, String message, String errorDetails) {
        super(message);
        this.exceptionCode = exceptionCode;
        this.errorDetails = errorDetails;
    }

    public UserNotFoundException(ExceptionCode code, String message, Throwable throwable) {
        super(message, throwable);
        this.exceptionCode = code;
        this.errorDetails = message;
    }

    public ExceptionCode getExceptionCodeEnum() {
        return exceptionCode;    }

   public String getErrorDetails() {
        return errorDetails;
    }
    public HttpStatus getStatus() {
        return exceptionCode.getHttpStatus();
    }
}
