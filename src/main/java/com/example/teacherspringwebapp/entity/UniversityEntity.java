package com.example.teacherspringwebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Data
@Table(name = "university")
public class UniversityEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "universityId", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TeacherEntity> teacherList;

    @JsonIgnore
    @OneToMany(mappedBy = "universityId", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<StudentEntity> studentList;


    @JsonIgnore
    @OneToMany(mappedBy = "universityId", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TeacherUniversityEntity> teacherUniversityList;

    @JsonIgnore
    @OneToMany(mappedBy = "universityId", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<StudentUniversityEntity> studentUniversityList;



    public UniversityEntity() {
    }

    public UniversityEntity(Integer id) {
        this.id = id;
    }

    public UniversityEntity(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }



    @Override
    public String toString() {
        return this.name;
    }

    @XmlTransient
    public List<TeacherUniversityEntity> getTeacherUniversityList() {
        return teacherUniversityList;
    }

    public void setTeacherUniversityList(List<TeacherUniversityEntity> teacherUniversityList) {
        this.teacherUniversityList = teacherUniversityList;
    }
    
}
