package com.example.teacherspringwebapp.entity;

import com.example.teacherspringwebapp.entity.UniversityEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "student")
@Data
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "scholarship")
    private BigDecimal scholarship;

//    @Basic(optional = false)
//    @Column(name = "username")
//    private String username;

//    @Basic(optional = false)
//    @Column(name = "password")
//    private String password;

    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @ManyToOne
    private UniversityEntity universityId;


    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;


    @JsonIgnore
    @OneToMany(mappedBy = "studentId")
    private List<StudentUniversityEntity> studentUniversityList;


}

