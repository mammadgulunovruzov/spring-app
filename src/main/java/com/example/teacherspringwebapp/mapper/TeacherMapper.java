package com.example.teacherspringwebapp.mapper;

import com.example.teacherspringwebapp.entity.TeacherEntity;
import com.example.teacherspringwebapp.restcontroler.dto.request.teacher.TeacherInsertRequestDto;
import com.example.teacherspringwebapp.restcontroler.dto.request.teacher.TeacherUpdateRequestDto;
import com.example.teacherspringwebapp.restcontroler.dto.response.teacher.TeacherResponseDto;
import com.example.teacherspringwebapp.service.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);


    TeacherDto toTeacherDto(TeacherInsertRequestDto requestDto);
    @Mapping(source = "universityId.id", target = "universityId")
    TeacherDto toTeacherDto(TeacherEntity teacherEntity);

    @Mapping(source = "universityId", target = "universityId.id")
    TeacherEntity toTeacherEntity(TeacherDto dto);

    @Mapping(source = "universityId", target = "universityId.id")
    TeacherEntity toTeacherEntity(TeacherUpdateRequestDto dto);


    @Mapping(source = "universityId.id", target = "universityId")
    TeacherResponseDto toTeacherResponseDto(TeacherEntity teacherEntity);
}
