
package com.copious.restAPI.RestApi.Constants;

import org.springframework.http.HttpStatus;

public enum ExceptionCode
{
     INTERNAL_SERVER_ERROR("Internal server error<Client error>",HttpStatus.INTERNAL_SERVER_ERROR),
    NO_USER_FOUND("User not present ",HttpStatus.NOT_FOUND),
    INVALID_USER("Invalid user(Client)", HttpStatus.BAD_REQUEST);


    private final String errorMessege;
    private final HttpStatus httpStatus;

    ExceptionCode(String errorMessege, HttpStatus httpStatus) {
        this.errorMessege = errorMessege;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessege() {
        return errorMessege;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage()
    {
        return errorMessege;
    }
}