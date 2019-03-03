package com.dev.ams.model;
// Generated Mar 2, 2019, 9:35:18 PM by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * TakeUpDefaulterCalendar generated by hbm2java
 */
@Entity
@Table(name = "take_up_defaulter_calendar")
public class TakeUpDefaulterCalendar implements java.io.Serializable {


    private Integer defaulterId;
    private Users users;
    private ClassCalendar classCalendar;

    public TakeUpDefaulterCalendar() {
    }

    public TakeUpDefaulterCalendar(Integer defaulterId, Users users, ClassCalendar classCalendar) {
        this.defaulterId = defaulterId;
        this.users = users;
        this.classCalendar = classCalendar;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "defaulter_id", unique = true, nullable = false)
    public Integer getDefaulterId() {
        return this.defaulterId;
    }

    public void setDefaulterId(Integer defaulterId) {
        this.defaulterId = defaulterId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_calendar_id", nullable = false)
    public ClassCalendar getClassCalendar() {
        return this.classCalendar;
    }

    public void setClassCalendar(ClassCalendar classCalendar) {
        this.classCalendar = classCalendar;
    }


}


