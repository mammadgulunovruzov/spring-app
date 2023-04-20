package com.example.teacherspringwebapp.restcontroler;


import com.example.teacherspringwebapp.entity.TeacherEntity;
import com.example.teacherspringwebapp.lib.NonSpringUtil;
import com.example.teacherspringwebapp.mapper.TeacherMapper;
import com.example.teacherspringwebapp.restcontroler.dto.request.teacher.TeacherUpdateRequestDto;
import com.example.teacherspringwebapp.restcontroler.dto.response.ResponseDto;
import com.example.teacherspringwebapp.restcontroler.dto.request.teacher.TeacherInsertRequestDto;
import com.example.teacherspringwebapp.restcontroler.dto.response.teacher.TeacherInsertResponseDto;
import com.example.teacherspringwebapp.restcontroler.dto.response.teacher.TeacherResponseDto;
import com.example.teacherspringwebapp.service.TeacherService;
import com.example.teacherspringwebapp.service.dto.TeacherDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "teachers")
public class TeacherRestController {


    private TeacherService teacherService;

    private final NonSpringUtil nonSpringUtil;

    public TeacherRestController(TeacherService teacherService, NonSpringUtil nonSpringUtil) {
        this.teacherService = teacherService;
        this.nonSpringUtil = nonSpringUtil;
    }

    @GetMapping
    public ResponseDto<List<TeacherResponseDto>> getList(@RequestParam(required = false, value = "name") String name,
                                                             @RequestParam(required = false,value = "surname") String surname,
                                                             @RequestParam(required = false,value = "salary") BigDecimal salary ){
        List<TeacherEntity> teacherEntityList = teacherService.getList(name, surname, salary);

        List<TeacherResponseDto> data = new ArrayList<>();
        for(TeacherEntity teacherEntity: teacherEntityList){
            data.add(TeacherMapper.INSTANCE.toTeacherResponseDto(teacherEntity));

        }


        ResponseDto<List<TeacherResponseDto>> responseDto  =  new ResponseDto<>();
        responseDto.setData(data);

        return responseDto;


    }

    @GetMapping("/{id}")
    public ResponseDto<TeacherResponseDto> getList(@PathVariable(required = false, name = "id") Integer id){
        TeacherEntity teacherEntity = teacherService.findById(id);

        return ResponseDto.ok(TeacherMapper.INSTANCE.toTeacherResponseDto(teacherEntity));


    }


    @PostMapping
    public ResponseDto<TeacherInsertResponseDto> add(@RequestBody TeacherInsertRequestDto teacherRequestDto){
        TeacherDto teacherDto = TeacherMapper.INSTANCE.toTeacherDto(teacherRequestDto);


        final TeacherDto addResult = teacherService.add(teacherDto);


        TeacherInsertResponseDto teacherInsertResponseDto =  new TeacherInsertResponseDto();
        teacherInsertResponseDto.setId(addResult.getId());
        final ResponseDto<TeacherInsertResponseDto> responseDto = new ResponseDto<>();


        return ResponseDto.ok(teacherInsertResponseDto);
    }

    @PutMapping
    public ResponseDto<Boolean> update(@RequestBody TeacherUpdateRequestDto teacherUpdateRequestDto){
        TeacherEntity teacherEntity = TeacherMapper.INSTANCE.toTeacherEntity(teacherUpdateRequestDto);

        return  ResponseDto.ok(teacherService.update(teacherEntity)!=null);
    }

    @DeleteMapping
    public ResponseDto<Boolean> delete(@RequestParam Integer id){
         teacherService.deleteById(id);

         return ResponseDto.ok(true);
    }




}
