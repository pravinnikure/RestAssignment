/*
package com.copious.restAPI.RestApi.Service;

import com.copious.restAPI.RestApi.Constants.ExceptionCode;
import org.springframework.http.HttpStatus;

public class InvalidUserException extends RuntimeException
{
    private final ExceptionCode exceptionCodeEnum;

    private final String errorDetails;

    public InvalidClientException(ExceptionCode exceptionCodeEnum, String message, String errorDetails) {
        super(message);
        this.exceptionCodeEnum = exceptionCodeEnum;
        this.errorDetails = errorDetails;
    }

    public InvalidClientException(ExceptionCode code, String message, Throwable throwable) {
        super(message, throwable);
        this.exceptionCodeEnum = code;
        this.errorDetails = message;
    }

    public ExceptionCode getExceptionCodeEnum() {
        return exceptionCodeEnum;
    }

    */
/**
     * Intended to get ErrorDetails.
     *
     * @return ErrorDetails String
     *//*

    public String getErrorDetails() {
        return errorDetails;
    }

    */
/**
     * Intended to get Http status of exception.
     *
     * @return HttpStatus
     *//*

    public HttpStatus getStatus() {
        return exceptionCodeEnum.getHttpStatus();
    }
}
*/
