package com.dev.ams.model;
// Generated Mar 3, 2019, 11:29:41 AM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "users"
)
public class Users implements java.io.Serializable {


    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private byte enabled;
    private String email;
    private String mobile;
    private String firstname;
    private String lastname;
    private Date dob;
    private String address;
    private String type;

    @JsonManagedReference(value = "authority")
    private Set<Authorities> authoritieses = new HashSet<Authorities>(0);

    @JsonManagedReference(value = "lectureSchedules-user")
    private Set<LectureSchedule> lectureSchedules = new HashSet<LectureSchedule>(0);
    private Set<StudentDetails> studentDetailses = new HashSet<StudentDetails>(0);
    private Set<ChapterDetails> chapterDetailses = new HashSet<ChapterDetails>(0);
    private Set<Feedback> feedbacksForGivenBy = new HashSet<Feedback>(0);
    private Set<Chapter> chapters = new HashSet<Chapter>(0);
    private Set<Feedback> feedbacksForGivenTo = new HashSet<Feedback>(0);

    @JsonManagedReference(value = "studentStandards-user")
    private Set<StudentStandard> studentStandards = new HashSet<StudentStandard>(0);

    public Users() {
    }


    public Users(String username, String password, byte enabled, String firstname, String address) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstname = firstname;
        this.address = address;
    }

    public Users(String username, String password, byte enabled, String email, String mobile, String firstname, String lastname, Date dob, String address, String type, Set<Authorities> authoritieses, Set<LectureSchedule> lectureSchedules, Set<StudentDetails> studentDetailses, Set<ChapterDetails> chapterDetailses, Set<Feedback> feedbacksForGivenBy, Set<Chapter> chapters, Set<Feedback> feedbacksForGivenTo, Set<StudentStandard> studentStandards) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.mobile = mobile;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.type = type;
        this.authoritieses = authoritieses;
        this.lectureSchedules = lectureSchedules;
        this.studentDetailses = studentDetailses;
        this.chapterDetailses = chapterDetailses;
        this.feedbacksForGivenBy = feedbacksForGivenBy;
        this.chapters = chapters;
        this.feedbacksForGivenTo = feedbacksForGivenTo;
        this.studentStandards = studentStandards;
    }

    @Id
    @Column(name = "username", unique = true, nullable = false, length = 45)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 100)
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

    @Column(name = "type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Authorities> getAuthoritieses() {
        return this.authoritieses;
    }

    public void setAuthoritieses(Set<Authorities> authoritieses) {
        this.authoritieses = authoritieses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<LectureSchedule> getLectureSchedules() {
        return this.lectureSchedules;
    }

    public void setLectureSchedules(Set<LectureSchedule> lectureSchedules) {
        this.lectureSchedules = lectureSchedules;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<StudentDetails> getStudentDetailses() {
        return this.studentDetailses;
    }

    public void setStudentDetailses(Set<StudentDetails> studentDetailses) {
        this.studentDetailses = studentDetailses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<ChapterDetails> getChapterDetailses() {
        return this.chapterDetailses;
    }

    public void setChapterDetailses(Set<ChapterDetails> chapterDetailses) {
        this.chapterDetailses = chapterDetailses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByGivenBy")
    public Set<Feedback> getFeedbacksForGivenBy() {
        return this.feedbacksForGivenBy;
    }

    public void setFeedbacksForGivenBy(Set<Feedback> feedbacksForGivenBy) {
        this.feedbacksForGivenBy = feedbacksForGivenBy;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Chapter> getChapters() {
        return this.chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByGivenTo")
    public Set<Feedback> getFeedbacksForGivenTo() {
        return this.feedbacksForGivenTo;
    }

    public void setFeedbacksForGivenTo(Set<Feedback> feedbacksForGivenTo) {
        this.feedbacksForGivenTo = feedbacksForGivenTo;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    public Set<StudentStandard> getStudentStandards() {
        return this.studentStandards;
    }

    public void setStudentStandards(Set<StudentStandard> studentStandards) {
        this.studentStandards = studentStandards;
    }
}


