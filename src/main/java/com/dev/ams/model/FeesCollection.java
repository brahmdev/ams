package com.dev.ams.model;
// Generated Jun 5, 2019 8:13:49 AM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
 * FeesCollection generated by hbm2java
 */
@Entity
@Table(name = "fees_collection"
)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property = "feesId")
public class FeesCollection implements java.io.Serializable {


    private Integer id;
    private Standard standard;
    private String studentUsername;
    private String feesTitle;
    private Integer amount;
    private Date date;
    private String payeeName;
    private String receiptNumber;
    private Date nextPaymentDate;

    public FeesCollection() {
    }


    public FeesCollection(Standard standard, String studentUsername, Integer amount, Date date, String payeeName) {
        this.standard = standard;
        this.studentUsername = studentUsername;
        this.amount = amount;
        this.date = date;
        this.payeeName = payeeName;
    }

    public FeesCollection(Standard standard, String studentUsername, String feesTitle, Integer amount, Date date, String payeeName, String receiptNumber, Date nextPaymentDate) {
        this.standard = standard;
        this.studentUsername = studentUsername;
        this.feesTitle = feesTitle;
        this.amount = amount;
        this.date = date;
        this.payeeName = payeeName;
        this.receiptNumber = receiptNumber;
        this.nextPaymentDate = nextPaymentDate;
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
    @JoinColumn(name = "standard_ id", nullable = false)
    public Standard getStandard() {
        return this.standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Column(name = "student_username", nullable = false, length = 30)
    public String getStudentUsername() {
        return this.studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    @Column(name = "fees_title", length = 45)
    public String getFeesTitle() {
        return this.feesTitle;
    }

    public void setFeesTitle(String feesTitle) {
        this.feesTitle = feesTitle;
    }

    @Column(name = "amount", nullable = false)
    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, length = 10)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "payee_name", nullable = false, length = 45)
    public String getPayeeName() {
        return this.payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    @Column(name = "receipt_number", length = 45)
    public String getReceiptNumber() {
        return this.receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "next_payment_date", length = 10)
    public Date getNextPaymentDate() {
        return this.nextPaymentDate;
    }

    public void setNextPaymentDate(Date nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }


}


