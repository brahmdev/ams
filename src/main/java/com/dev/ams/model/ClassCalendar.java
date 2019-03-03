package com.dev.ams.model;
// Generated Mar 3, 2019, 8:14:57 PM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonBackReference;

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

/**
 * ClassCalendar generated by hbm2java
 */
@Entity
@Table(name = "class_calendar"
)
public class ClassCalendar implements java.io.Serializable {


    private Integer id;

    @JsonBackReference(value="classCalendar")
    private Standard standard;
    private String month;
    private String day;
    private String year;
    private String eventName;
    private String eventDescription;
    private String eventType;
    private Set<TestResult> testResults = new HashSet<TestResult>(0);
    private Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars = new HashSet<TakeUpDefaulterCalendar>(0);

    public ClassCalendar() {
    }


    public ClassCalendar(Standard standard, String month, String day, String year, String eventName, String eventDescription, String eventType) {
        this.standard = standard;
        this.month = month;
        this.day = day;
        this.year = year;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
    }

    public ClassCalendar(Standard standard, String month, String day, String year, String eventName, String eventDescription, String eventType, Set<TestResult> testResults, Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars) {
        this.standard = standard;
        this.month = month;
        this.day = day;
        this.year = year;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.testResults = testResults;
        this.takeUpDefaulterCalendars = takeUpDefaulterCalendars;
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
    @JoinColumn(name = "standard_id", nullable = false)
    public Standard getStandard() {
        return this.standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Column(name = "month", nullable = false, length = 45)
    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Column(name = "day", nullable = false, length = 45)
    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Column(name = "year", nullable = false, length = 45)
    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "event_name", nullable = false, length = 45)
    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Column(name = "event_description", nullable = false, length = 45)
    public String getEventDescription() {
        return this.eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Column(name = "event_type", nullable = false, length = 45)
    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classCalendar")
    public Set<TestResult> getTestResults() {
        return this.testResults;
    }

    public void setTestResults(Set<TestResult> testResults) {
        this.testResults = testResults;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classCalendar")
    public Set<TakeUpDefaulterCalendar> getTakeUpDefaulterCalendars() {
        return this.takeUpDefaulterCalendars;
    }

    public void setTakeUpDefaulterCalendars(Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars) {
        this.takeUpDefaulterCalendars = takeUpDefaulterCalendars;
    }


}


