package com.dev.ams.model;
// Generated Mar 2, 2019, 9:35:18 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Feedback generated by hbm2java
 */
@Entity
@Table(name = "feedback")
public class Feedback implements java.io.Serializable {


    private Integer feedbackId;
    private Users usersByGivenBy;
    private Users usersByGivenTo;
    private String comments;
    private Integer givenOn;
    private String rating;
    private String feedbackType;

    public Feedback() {
    }


    public Feedback(Integer feedbackId, Users usersByGivenBy, Users usersByGivenTo, Integer givenOn, String rating, String feedbackType) {
        this.feedbackId = feedbackId;
        this.usersByGivenBy = usersByGivenBy;
        this.usersByGivenTo = usersByGivenTo;
        this.givenOn = givenOn;
        this.rating = rating;
        this.feedbackType = feedbackType;
    }

    public Feedback(Integer feedbackId, Users usersByGivenBy, Users usersByGivenTo, String comments, Integer givenOn, String rating, String feedbackType) {
        this.feedbackId = feedbackId;
        this.usersByGivenBy = usersByGivenBy;
        this.usersByGivenTo = usersByGivenTo;
        this.comments = comments;
        this.givenOn = givenOn;
        this.rating = rating;
        this.feedbackType = feedbackType;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "feedback_id", unique = true, nullable = false)
    public Integer getFeedbackId() {
        return this.feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "given_by", nullable = false)
    public Users getUsersByGivenBy() {
        return this.usersByGivenBy;
    }

    public void setUsersByGivenBy(Users usersByGivenBy) {
        this.usersByGivenBy = usersByGivenBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "given_to", nullable = false)
    public Users getUsersByGivenTo() {
        return this.usersByGivenTo;
    }

    public void setUsersByGivenTo(Users usersByGivenTo) {
        this.usersByGivenTo = usersByGivenTo;
    }

    @Column(name = "comments", length = 45)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "given_on", nullable = false)
    public Integer getGivenOn() {
        return this.givenOn;
    }

    public void setGivenOn(Integer givenOn) {
        this.givenOn = givenOn;
    }

    @Column(name = "rating", nullable = false, length = 45)
    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Column(name = "feedback_type", nullable = false, length = 45)
    public String getFeedbackType() {
        return this.feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }


}


