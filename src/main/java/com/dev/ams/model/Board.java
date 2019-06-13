package com.dev.ams.model;
// Generated Jun 13, 2019 7:21:37 PM by Hibernate Tools 3.2.2.GA


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
 * Board generated by hbm2java
 */
@Entity
@Table(name = "board"
)
public class Board implements java.io.Serializable {


    private Integer id;
    private Branch branch;
    private String code;
    private String name;

    @JsonBackReference(value="board-standard")
    private Set<Standard> standards = new HashSet<Standard>(0);

    public Board() {
    }

    public Board(Branch branch, String code, String name, Set<Standard> standards) {
        this.branch = branch;
        this.code = code;
        this.name = name;
        this.standards = standards;
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
    @JoinColumn(name = "branch_id")
    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Column(name = "code", length = 10)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "board")
    public Set<Standard> getStandards() {
        return this.standards;
    }

    public void setStandards(Set<Standard> standards) {
        this.standards = standards;
    }


}

