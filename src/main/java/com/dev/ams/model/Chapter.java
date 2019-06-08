package com.dev.ams.model;
// Generated Jun 5, 2019 8:13:49 AM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
 * Chapter generated by hbm2java
 */
@Entity
@Table(name = "chapter"
)
public class Chapter implements java.io.Serializable {


    private Integer id;

    private Subject subject;
    private String code;
    private Integer number;
    private String name;

    @JsonBackReference(value="chapter-chapterDetails")
    private Set<ChapterDetails> chapterDetailses = new HashSet<ChapterDetails>(0);

    public Chapter() {
    }


    public Chapter(Subject subject, String code, Integer number) {
        this.subject = subject;
        this.code = code;
        this.number = number;
    }

    public Chapter(Subject subject, String code, Integer number, String name, Set<ChapterDetails> chapterDetailses) {
        this.subject = subject;
        this.code = code;
        this.number = number;
        this.name = name;
        this.chapterDetailses = chapterDetailses;
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
    @JoinColumn(name = "subject_id", nullable = false)
    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "number", nullable = false)
    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "name", length = 60)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "chapter")
    public Set<ChapterDetails> getChapterDetailses() {
        return this.chapterDetailses;
    }

    public void setChapterDetailses(Set<ChapterDetails> chapterDetailses) {
        this.chapterDetailses = chapterDetailses;
    }


}


