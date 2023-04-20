package com.example.teacherspringwebapp.mapper;

import com.example.teacherspringwebapp.entity.StudentEntity;
import com.example.teacherspringwebapp.restcontroler.dto.request.student.StudentInsertRequestDto;
import com.example.teacherspringwebapp.restcontroler.dto.request.student.StudentUpdateRequestDto;
import com.example.teacherspringwebapp.restcontroler.dto.response.student.StudentResponseDto;
import com.example.teacherspringwebapp.service.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);


    StudentDto toStudentDto(StudentInsertRequestDto requestDto);
    @Mapping(source = "universityId.id", target = "universityId")
    StudentDto toStudentDto(StudentEntity studentEntity);

    @Mapping(source = "universityId", target = "universityId.id")
    StudentEntity toStudentEntity(StudentDto dto);

    @Mapping(source = "universityId", target = "universityId.id")
    StudentEntity toStudentEntity(StudentUpdateRequestDto dto);


    @Mapping(source = "universityId.id", target = "universityId")
    StudentResponseDto toStudentResponseDto(StudentEntity studentEntity);
}
