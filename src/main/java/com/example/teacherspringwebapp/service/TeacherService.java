package com.example.teacherspringwebapp.service;

import com.example.teacherspringwebapp.entity.TeacherEntity;
import com.example.teacherspringwebapp.mapper.TeacherMapper;
import com.example.teacherspringwebapp.repository.TeacherRepository;
import com.example.teacherspringwebapp.service.dto.TeacherDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Primary
public class TeacherService{

    private TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public TeacherDto add(TeacherDto teacherDto){
        TeacherEntity teacher = TeacherMapper.INSTANCE.toTeacherEntity(teacherDto);


        repository.save(teacher);

        teacherDto.setId(teacher.getId());

        return teacherDto;


    }
    public TeacherEntity findById(Integer id) {
        return repository.getOne(id);
    }


    public List<TeacherEntity> getList(String name, String surname,BigDecimal salary){

        Specification<TeacherEntity> specification = new Specification<TeacherEntity>() {
            @Override
            public Predicate toPredicate(Root<TeacherEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (name != null && name.trim().length() > 0) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                if (surname != null && surname.trim().length() > 0) {
                    predicates.add(cb.like(root.get("surname").as(String.class), "%" + surname + "%"));
                }
                if (salary != null) {
                    predicates.add(cb.equal(root.get("salary").as(BigDecimal.class), salary));
                }

                return cb.and(predicates.toArray(new Predicate[]{}));
            }
        };
        return repository.findAll(specification);

    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public TeacherEntity update(TeacherEntity teacherEntity) {
        return repository.save(teacherEntity);
    }


}
