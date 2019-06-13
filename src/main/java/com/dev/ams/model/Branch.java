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
 * Branch generated by hbm2java
 */
@Entity
@Table(name = "branch"
)
public class Branch implements java.io.Serializable {


    private Integer id;
    private Institute institute;
    private String code;
    private String name;
    private String address;

    @JsonBackReference(value="users-branch")
    private Set<Users> userses = new HashSet<Users>(0);

    @JsonBackReference(value="board-branch")
    private Set<Board> boards = new HashSet<Board>(0);

    public Branch() {
    }


    public Branch(String code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public Branch(Institute institute, String code, String name, String address, Set<Users> userses, Set<Board> boards) {
        this.institute = institute;
        this.code = code;
        this.name = name;
        this.address = address;
        this.userses = userses;
        this.boards = boards;
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
    @JoinColumn(name = "institute_id")
    public Institute getInstitute() {
        return this.institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", nullable = false, length = 200)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branch")
    public Set<Users> getUserses() {
        return this.userses;
    }

    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branch")
    public Set<Board> getBoards() {
        return this.boards;
    }

    public void setBoards(Set<Board> boards) {
        this.boards = boards;
    }


}


