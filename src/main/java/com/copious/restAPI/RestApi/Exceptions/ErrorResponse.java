package com.copious.restAPI.RestApi.Exceptions;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ErrorResponse implements Serializable
{
    @ApiModelProperty(position = 2,
        value = "Response Message",
        name = "message",
        dataType = "java.lang.String",
        required = true)
private String errorMessage;

    private String errorDetails;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMessage, String errorDetails) {
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
