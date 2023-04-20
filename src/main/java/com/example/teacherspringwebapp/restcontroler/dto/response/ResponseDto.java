package com.example.teacherspringwebapp.restcontroler.dto.response;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ResponseDto<T> {

    private String message;
    private LocalDateTime date = LocalDateTime.now();
    private int code;
    private T data;


    public static <T> ResponseDto<T> ok (T data){
        ResponseDto<T> responseDto =  new ResponseDto<>();
        responseDto.setData(data);
        responseDto.setMessage("success");

        return responseDto;

    }
}
