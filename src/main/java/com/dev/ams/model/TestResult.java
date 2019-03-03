package com.dev.ams.model;
// Generated Mar 2, 2019, 9:35:18 PM by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * TestResult generated by hbm2java
 */
@Entity
@Table(name = "test_result")
public class TestResult implements java.io.Serializable {


    private Integer testResultId;
    private ClassCalendar classCalendar;
    private String studentId;
    private Integer marksObtained;
    private Integer outOf;
    private String status;

    public TestResult() {
    }


    public TestResult(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public TestResult(Integer testResultId, ClassCalendar classCalendar, String studentId, Integer marksObtained, Integer outOf, String status) {
        this.testResultId = testResultId;
        this.classCalendar = classCalendar;
        this.studentId = studentId;
        this.marksObtained = marksObtained;
        this.outOf = outOf;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "test_result_id", unique = true, nullable = false)
    public Integer getTestResultId() {
        return this.testResultId;
    }

    public void setTestResultId(Integer testResultId) {
        this.testResultId = testResultId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_calendar_id")
    public ClassCalendar getClassCalendar() {
        return this.classCalendar;
    }

    public void setClassCalendar(ClassCalendar classCalendar) {
        this.classCalendar = classCalendar;
    }

    @Column(name = "student_id", length = 45)
    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Column(name = "marks_obtained")
    public Integer getMarksObtained() {
        return this.marksObtained;
    }

    public void setMarksObtained(Integer marksObtained) {
        this.marksObtained = marksObtained;
    }

    @Column(name = "out_of")
    public Integer getOutOf() {
        return this.outOf;
    }

    public void setOutOf(Integer outOf) {
        this.outOf = outOf;
    }

    @Column(name = "status", length = 45)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}


