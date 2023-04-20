package com.example.teacherspringwebapp.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherDto {


    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;
}
