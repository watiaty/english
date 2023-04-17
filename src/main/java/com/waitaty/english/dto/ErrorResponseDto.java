package com.waitaty.english.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {

    private String message;
    private String status;
    private String error;

}
