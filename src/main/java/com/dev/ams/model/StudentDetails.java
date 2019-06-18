package com.dev.ams.model;
// Generated Jun 5, 2019 8:13:49 AM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StudentDetails generated by hbm2java
 */
@Entity
@Table(name = "student_details"
)
public class StudentDetails implements java.io.Serializable {


    private Integer id;

    @JsonIgnore
    private Users users;
    private Batch batch;
    private String rollNo;
    private Date admissionDate;
    private Character hasPaidFees;
    private String parentsUsername;
    private Set<StudentAttendance> studentAttendances = new HashSet<StudentAttendance>(0);

    public StudentDetails() {
    }


    public StudentDetails(Users users, Batch batch, String rollNo) {
        this.users = users;
        this.batch = batch;
        this.rollNo = rollNo;
    }

    public StudentDetails(Users users, Batch batch, String rollNo, Date admissionDate, Character hasPaidFees, String parentsUsername, Set<StudentAttendance> studentAttendances) {
        this.users = users;
        this.batch = batch;
        this.rollNo = rollNo;
        this.admissionDate = admissionDate;
        this.hasPaidFees = hasPaidFees;
        this.parentsUsername = parentsUsername;
        this.studentAttendances = studentAttendances;
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
    @JoinColumn(name = "users_id", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id", nullable = false)
    public Batch getBatch() {
        return this.batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Column(name = "roll_no", nullable = false, length = 45)
    public String getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "admission_date", length = 19)
    public Date getAdmissionDate() {
        return this.admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Column(name = "has_paid_fees", length = 1)
    public Character getHasPaidFees() {
        return this.hasPaidFees;
    }

    public void setHasPaidFees(Character hasPaidFees) {
        this.hasPaidFees = hasPaidFees;
    }

    @Column(name = "parents_username", length = 100)
    public String getParentsUsername() {
        return this.parentsUsername;
    }

    public void setParentsUsername(String parentsUsername) {
        this.parentsUsername = parentsUsername;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "studentDetails")
    public Set<StudentAttendance> getStudentAttendances() {
        return this.studentAttendances;
    }

    public void setStudentAttendances(Set<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }
}


