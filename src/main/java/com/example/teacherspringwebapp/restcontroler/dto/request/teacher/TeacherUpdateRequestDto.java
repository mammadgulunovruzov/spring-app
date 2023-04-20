package com.example.teacherspringwebapp.restcontroler.dto.request.teacher;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TeacherUpdateRequestDto {

    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private Integer universityId;
}
