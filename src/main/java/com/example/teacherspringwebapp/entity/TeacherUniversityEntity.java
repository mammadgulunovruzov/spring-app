package com.example.teacherspringwebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "teacher_university")
public class TeacherUniversityEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @ManyToOne
    private TeacherEntity teacherId;
    @JsonIgnore
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @ManyToOne
    private UniversityEntity universityId;




    public TeacherUniversityEntity() {
    }

    public TeacherUniversityEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeacherEntity getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherEntity teacherId) {
        this.teacherId = teacherId;
    }

    public UniversityEntity getUniversityId() {
        return universityId;
    }

    public void setUniversityId(UniversityEntity universityId) {
        this.universityId = universityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherUniversityEntity)) {
            return false;
        }
        TeacherUniversityEntity other = (TeacherUniversityEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TeacherUniversity[ id=" + id + " ]";
    }
    
}
