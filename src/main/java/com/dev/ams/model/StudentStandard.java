package com.dev.ams.model;
// Generated Mar 3, 2019, 8:14:57 PM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StudentStandard generated by hbm2java
 */
@Entity
@Table(name = "student_standard"
)
public class StudentStandard implements java.io.Serializable {


    private Integer id;
    private Users users;

    @JsonBackReference(value="studentStandard")
    private Standard standard;

    public StudentStandard() {
    }

    public StudentStandard(Users users, Standard standard) {
        this.users = users;
        this.standard = standard;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id", nullable = false)
    public Standard getStandard() {
        return this.standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }


}


