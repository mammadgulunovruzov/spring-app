package com.example.teacherspringwebapp.restcontroler.dto.response.student;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentResponseDto {


    private Integer id;
    private String name;
    private String surname;
    private BigDecimal scholarship;
    private Integer universityId;
}
