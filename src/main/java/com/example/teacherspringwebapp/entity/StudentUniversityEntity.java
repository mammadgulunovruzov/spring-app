package com.example.teacherspringwebapp.entity;

import com.example.teacherspringwebapp.entity.StudentEntity;
import com.example.teacherspringwebapp.entity.UniversityEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "student_university")
public class StudentUniversityEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne
    private StudentEntity studentId;
    @JsonIgnore
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @ManyToOne
    private UniversityEntity universityId;



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentUniversityEntity)) {
            return false;
        }
        StudentUniversityEntity other = (StudentUniversityEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StudentUniversity[ id=" + id + " ]";
    }

}
