package com.dev.ams.model;
// Generated Mar 3, 2019, 8:14:57 PM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonBackReference;

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
 * QuestionPapers generated by hbm2java
 */
@Entity
@Table(name = "question_papers"
)
public class QuestionPapers implements java.io.Serializable {


    private Integer id;

    @JsonBackReference(value="questionPaper-board")
    private Board board;

    @JsonBackReference(value="subject-questionPapers")
    private Subject subject;

    @JsonBackReference(value="questionPaper")
    private Standard standard;
    private byte[] content;
    private Date created;
    private String createdBy;
    private String paperName;
    private Date updated;

    public QuestionPapers() {
    }


    public QuestionPapers(Board board, Subject subject, Standard standard, byte[] content, String paperName) {
        this.board = board;
        this.subject = subject;
        this.standard = standard;
        this.content = content;
        this.paperName = paperName;
    }

    public QuestionPapers(Board board, Subject subject, Standard standard, byte[] content, Date created, String createdBy, String paperName, Date updated) {
        this.board = board;
        this.subject = subject;
        this.standard = standard;
        this.content = content;
        this.created = created;
        this.createdBy = createdBy;
        this.paperName = paperName;
        this.updated = updated;
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
    @JoinColumn(name = "board_id", nullable = false)
    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
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
    @JoinColumn(name = "standard_id", nullable = false)
    public Standard getStandard() {
        return this.standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Column(name = "content", nullable = false)
    public byte[] getContent() {
        return this.content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "created", length = 10)
    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "created_by", length = 45)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "paper_name", nullable = false, length = 45)
    public String getPaperName() {
        return this.paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "updated", length = 10)
    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


}


