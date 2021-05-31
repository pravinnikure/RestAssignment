package com.copious.restAPI.RestApi.Exceptions;

import com.copious.restAPI.RestApi.Constants.ExceptionCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {InvalidUserException.class})
    private ResponseEntity<Object> handle(InvalidUserException exception, WebRequest webRequest) {
        return handleExceptionInternal(exception,
                new GenericResponse<>(false,
                        ExceptionCode.INVALID_USER.getHttpStatus().name(),
                        new ErrorResponse(ExceptionCode.INVALID_USER.getMessage(),
                                exception.getErrorDetails()
                        )),
                new HttpHeaders(),
                ExceptionCode.INVALID_USER.getHttpStatus(),
                webRequest
        );
    }

    @ExceptionHandler
    public ResponseEntity<Object> handle(UserNotFoundException exception, WebRequest webRequest) {
        return handleExceptionInternal(exception,
                new GenericResponse<>(false,
                        ExceptionCode.NO_USER_FOUND.getHttpStatus().name(),
                        new ErrorResponse(ExceptionCode.NO_USER_FOUND.getMessage(),
                                exception.getMessage()
                        )),
                new HttpHeaders(),
                ExceptionCode.NO_USER_FOUND.getHttpStatus(),
                webRequest
        );
    }

    public ResponseEntity<Object> handle(Exception exception, WebRequest webRequest) {
        return handleExceptionInternal(exception,
                new GenericResponse<>(false,
                        ExceptionCode.INTERNAL_SERVER_ERROR.getHttpStatus().name(),
                        new ErrorResponse(exception.getMessage(), exception.getMessage())),
                new HttpHeaders(),
                ExceptionCode.INTERNAL_SERVER_ERROR.getHttpStatus(),
                webRequest
        );
    }
}
