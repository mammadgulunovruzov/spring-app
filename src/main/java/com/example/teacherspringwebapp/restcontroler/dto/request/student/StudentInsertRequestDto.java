package com.example.teacherspringwebapp.restcontroler.dto.request.student;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentInsertRequestDto {

    private String name;
    private String surname;
    private BigDecimal scholarship;
    private Integer universityId;
}
