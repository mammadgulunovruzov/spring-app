package com.example.teacherspringwebapp.repository;

import com.example.teacherspringwebapp.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer>, JpaSpecificationExecutor<TeacherEntity> {

    @Query(value = "select t from TeacherEntity t where t.name=:name and t.surname=:surname")
    List<TeacherEntity> findAllByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    TeacherEntity findByNameAndSurname(String name, String surname);

    List<TeacherEntity> findAllByNameAndSurnameOrderByIdDesc(String name, String surname);

    TeacherEntity findByUsername(String username);



}
