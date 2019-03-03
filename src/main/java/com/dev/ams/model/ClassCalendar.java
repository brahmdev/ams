package com.dev.ams.model;
// Generated Mar 2, 2019, 9:35:18 PM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * ClassCalendar generated by hbm2java
 */
@Entity
@Table(name = "class_calendar")
public class ClassCalendar implements java.io.Serializable {


    private Integer classCalendarId;
    private Standard standard;
    private String month;
    private String day;
    private String year;
    private String eventName;
    private String eventDescription;
    private String eventType;
    private Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars = new HashSet<TakeUpDefaulterCalendar>(0);
    private Set<TestResult> testResults = new HashSet<TestResult>(0);
    private Set<TestResult> testResults_1 = new HashSet<TestResult>(0);
    private Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars_1 = new HashSet<TakeUpDefaulterCalendar>(0);

    public ClassCalendar() {
    }


    public ClassCalendar(Integer classCalendarId, Standard standard, String month, String day, String year, String eventName, String eventDescription, String eventType) {
        this.classCalendarId = classCalendarId;
        this.standard = standard;
        this.month = month;
        this.day = day;
        this.year = year;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
    }

    public ClassCalendar(Integer classCalendarId, Standard standard, String month, String day, String year, String eventName, String eventDescription, String eventType, Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars, Set<TestResult> testResults, Set<TestResult> testResults_1, Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars_1) {
        this.classCalendarId = classCalendarId;
        this.standard = standard;
        this.month = month;
        this.day = day;
        this.year = year;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.takeUpDefaulterCalendars = takeUpDefaulterCalendars;
        this.testResults = testResults;
        this.testResults_1 = testResults_1;
        this.takeUpDefaulterCalendars_1 = takeUpDefaulterCalendars_1;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "class_calendar_id", unique = true, nullable = false)
    public Integer getClassCalendarId() {
        return this.classCalendarId;
    }

    public void setClassCalendarId(Integer classCalendarId) {
        this.classCalendarId = classCalendarId;
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
    public Set<TakeUpDefaulterCalendar> getTakeUpDefaulterCalendars() {
        return this.takeUpDefaulterCalendars;
    }

    public void setTakeUpDefaulterCalendars(Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars) {
        this.takeUpDefaulterCalendars = takeUpDefaulterCalendars;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classCalendar")
    public Set<TestResult> getTestResults() {
        return this.testResults;
    }

    public void setTestResults(Set<TestResult> testResults) {
        this.testResults = testResults;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classCalendar")
    public Set<TestResult> getTestResults_1() {
        return this.testResults_1;
    }

    public void setTestResults_1(Set<TestResult> testResults_1) {
        this.testResults_1 = testResults_1;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classCalendar")
    public Set<TakeUpDefaulterCalendar> getTakeUpDefaulterCalendars_1() {
        return this.takeUpDefaulterCalendars_1;
    }

    public void setTakeUpDefaulterCalendars_1(Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars_1) {
        this.takeUpDefaulterCalendars_1 = takeUpDefaulterCalendars_1;
    }


}


