package com.copious.restAPI.RestApi.Model;

import lombok.*;
    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Exception {
        String code;
        String message;
        String errorType;
    }