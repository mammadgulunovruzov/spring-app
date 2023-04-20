package com.example.teacherspringwebapp.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentDto {

    private Integer id;
    private String name;
    private String surname;
    private BigDecimal scholarship;
    private Integer universityId;
}
