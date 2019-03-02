package com.dev.ams.model;
// Generated Mar 2, 2019, 9:35:18 PM by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {


    private String username;
    private String password;
    private byte enabled;
    private String email;
    private String mobile;
    private String firstname;
    private String lastname;
    private Date dob;
    private String address;
    private Set<StudentStandard> studentStandards = new HashSet<StudentStandard>(0);
    private Set<Chapter> chapters = new HashSet<Chapter>(0);
    private Set<StudentStandard> studentStandards_1 = new HashSet<StudentStandard>(0);
    private Set<LectureSchedule> lectureSchedules = new HashSet<LectureSchedule>(0);
    private Set<Feedback> feedbacksForGivenBy = new HashSet<Feedback>(0);
    private Set<UserRoles> userRoleses = new HashSet<UserRoles>(0);
    private Set<Chapter> chapters_1 = new HashSet<Chapter>(0);
    private Set<Chapter> chapters_2 = new HashSet<Chapter>(0);
    private Set<Feedback> feedbacksForGivenTo = new HashSet<Feedback>(0);
    private Set<LectureSchedule> lectureSchedules_1 = new HashSet<LectureSchedule>(0);
    private Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars = new HashSet<TakeUpDefaulterCalendar>(0);
    private Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars_1 = new HashSet<TakeUpDefaulterCalendar>(0);

    public Users() {
    }


    public Users(String username, String password, byte enabled, String firstname, String address) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstname = firstname;
        this.address = address;
    }

    public Users(String username, String password, byte enabled, String email, String mobile, String firstname, String lastname, Date dob, String address, Set<StudentStandard> studentStandards, Set<Chapter> chapters, Set<StudentStandard> studentStandards_1, Set<LectureSchedule> lectureSchedules, Set<Feedback> feedbacksForGivenBy, Set<UserRoles> userRoleses, Set<Chapter> chapters_1, Set<Chapter> chapters_2, Set<Feedback> feedbacksForGivenTo, Set<LectureSchedule> lectureSchedules_1, Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars, Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars_1) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.mobile = mobile;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.studentStandards = studentStandards;
        this.chapters = chapters;
        this.studentStandards_1 = studentStandards_1;
        this.lectureSchedules = lectureSchedules;
        this.feedbacksForGivenBy = feedbacksForGivenBy;
        this.userRoleses = userRoleses;
        this.chapters_1 = chapters_1;
        this.chapters_2 = chapters_2;
        this.feedbacksForGivenTo = feedbacksForGivenTo;
        this.lectureSchedules_1 = lectureSchedules_1;
        this.takeUpDefaulterCalendars = takeUpDefaulterCalendars;
        this.takeUpDefaulterCalendars_1 = takeUpDefaulterCalendars_1;
    }

    @Id
    @Column(name = "username", unique = true, nullable = false, length = 45)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "enabled", nullable = false)
    public byte getEnabled() {
        return this.enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    @Column(name = "email", length = 75)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "mobile", length = 10)
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "firstname", nullable = false, length = 45)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", length = 45)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "address", nullable = false, length = 150)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<StudentStandard> getStudentStandards() {
        return this.studentStandards;
    }

    public void setStudentStandards(Set<StudentStandard> studentStandards) {
        this.studentStandards = studentStandards;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Chapter> getChapters() {
        return this.chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<StudentStandard> getStudentStandards_1() {
        return this.studentStandards_1;
    }

    public void setStudentStandards_1(Set<StudentStandard> studentStandards_1) {
        this.studentStandards_1 = studentStandards_1;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<LectureSchedule> getLectureSchedules() {
        return this.lectureSchedules;
    }

    public void setLectureSchedules(Set<LectureSchedule> lectureSchedules) {
        this.lectureSchedules = lectureSchedules;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByGivenBy")
    public Set<Feedback> getFeedbacksForGivenBy() {
        return this.feedbacksForGivenBy;
    }

    public void setFeedbacksForGivenBy(Set<Feedback> feedbacksForGivenBy) {
        this.feedbacksForGivenBy = feedbacksForGivenBy;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<UserRoles> getUserRoleses() {
        return this.userRoleses;
    }

    public void setUserRoleses(Set<UserRoles> userRoleses) {
        this.userRoleses = userRoleses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Chapter> getChapters_1() {
        return this.chapters_1;
    }

    public void setChapters_1(Set<Chapter> chapters_1) {
        this.chapters_1 = chapters_1;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Chapter> getChapters_2() {
        return this.chapters_2;
    }

    public void setChapters_2(Set<Chapter> chapters_2) {
        this.chapters_2 = chapters_2;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByGivenTo")
    public Set<Feedback> getFeedbacksForGivenTo() {
        return this.feedbacksForGivenTo;
    }

    public void setFeedbacksForGivenTo(Set<Feedback> feedbacksForGivenTo) {
        this.feedbacksForGivenTo = feedbacksForGivenTo;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<LectureSchedule> getLectureSchedules_1() {
        return this.lectureSchedules_1;
    }

    public void setLectureSchedules_1(Set<LectureSchedule> lectureSchedules_1) {
        this.lectureSchedules_1 = lectureSchedules_1;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<TakeUpDefaulterCalendar> getTakeUpDefaulterCalendars() {
        return this.takeUpDefaulterCalendars;
    }

    public void setTakeUpDefaulterCalendars(Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars) {
        this.takeUpDefaulterCalendars = takeUpDefaulterCalendars;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<TakeUpDefaulterCalendar> getTakeUpDefaulterCalendars_1() {
        return this.takeUpDefaulterCalendars_1;
    }

    public void setTakeUpDefaulterCalendars_1(Set<TakeUpDefaulterCalendar> takeUpDefaulterCalendars_1) {
        this.takeUpDefaulterCalendars_1 = takeUpDefaulterCalendars_1;
    }


}

