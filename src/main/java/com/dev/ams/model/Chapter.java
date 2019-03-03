package com.dev.ams.model;
// Generated Mar 3, 2019, 8:14:57 PM by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Chapter generated by hbm2java
 */
@Entity
@Table(name = "chapter"
)
public class Chapter implements java.io.Serializable {


    private Integer id;
    private Users users;
    private Subject subject;
    private String number;
    private String name;
    private Date startDate;
    private Date finishDate;
    private Integer timeTaken;
    private String status;

    public Chapter() {
    }


    public Chapter(Subject subject, String number, String name, String status) {
        this.subject = subject;
        this.number = number;
        this.name = name;
        this.status = status;
    }

    public Chapter(Users users, Subject subject, String number, String name, Date startDate, Date finishDate, Integer timeTaken, String status) {
        this.users = users;
        this.subject = subject;
        this.number = number;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.timeTaken = timeTaken;
        this.status = status;
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
    @JoinColumn(name = "taken_by")
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Column(name = "number", nullable = false, length = 45)
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", length = 10)
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "finish_date", length = 10)
    public Date getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Column(name = "time_taken")
    public Integer getTimeTaken() {
        return this.timeTaken;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}


