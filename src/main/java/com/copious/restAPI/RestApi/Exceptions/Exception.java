package com.copious.restAPI.RestApi.Exceptions;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exception extends java.lang.Exception {
    String code;
    String message;
    String errorType;
}