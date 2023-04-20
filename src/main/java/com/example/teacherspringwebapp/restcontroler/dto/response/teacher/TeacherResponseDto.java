package com.example.teacherspringwebapp.restcontroler.dto.response.teacher;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherResponseDto {


    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;
}
