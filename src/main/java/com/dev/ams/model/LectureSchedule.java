package com.dev.ams.model;
// Generated Mar 15, 2019, 9:06:04 PM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
 * LectureSchedule generated by hbm2java
 */
@Entity
@Table(name = "lecture_schedule"
)
public class LectureSchedule implements java.io.Serializable {


    private Integer id;

    @JsonBackReference(value="lectureSchedules-user")
    private Users users;

    @JsonBackReference(value="subject-lectureSchedule")
    private Subject subject;
    private Batch batch;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date endTime;
    private Integer dayNumber;

    @JsonManagedReference(value = "lectureSchedules-status")
    private Set<LectureScheduleStatus> lectureScheduleStatuses = new HashSet<LectureScheduleStatus>(0);

    public LectureSchedule() {
    }


    public LectureSchedule(Users users, Subject subject, Batch batch, Date startTime, Date endTime) {
        this.users = users;
        this.subject = subject;
        this.batch = batch;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LectureSchedule(Users users, Subject subject, Batch batch, Date startTime, Date endTime, Integer dayNumber, Set<LectureScheduleStatus> lectureScheduleStatuses) {
        this.users = users;
        this.subject = subject;
        this.batch = batch;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayNumber = dayNumber;
        this.lectureScheduleStatuses = lectureScheduleStatuses;
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
    @JoinColumn(name = "taken_by", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_id", nullable = false)
    public Batch getBatch() {
        return this.batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time", nullable = false, length = 8)
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time", nullable = false, length = 8)
    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Column(name = "day_number", nullable = false)
    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lectureSchedule")
    public Set<LectureScheduleStatus> getLectureScheduleStatuses() {
        return this.lectureScheduleStatuses;
    }

    public void setLectureScheduleStatuses(Set<LectureScheduleStatus> lectureScheduleStatuses) {
        this.lectureScheduleStatuses = lectureScheduleStatuses;
    }


}


