package com.example.teacherspringwebapp.restcontroler.dto.request.teacher;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherInsertRequestDto {

    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;
}
