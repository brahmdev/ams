package com.dev.ams.model;
// Generated Mar 2, 2019, 9:35:18 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StudentStandard generated by hbm2java
 */
@Entity
@Table(name = "student_standard")
public class StudentStandard implements java.io.Serializable {


    private Integer studentDetailId;
    private Standard standard;
    private Users users;

    public StudentStandard() {
    }

    public StudentStandard(Integer studentDetailId, Standard standard, Users users) {
        this.studentDetailId = studentDetailId;
        this.standard = standard;
        this.users = users;
    }

    @Id
    @Column(name = "student_detail_id", unique = true, nullable = false)
    public Integer getStudentDetailId() {
        return this.studentDetailId;
    }

    public void setStudentDetailId(Integer studentDetailId) {
        this.studentDetailId = studentDetailId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id", nullable = false)
    public Standard getStandard() {
        return this.standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


}

