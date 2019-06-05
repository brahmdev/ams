package com.dev.ams.model;
// Generated Jun 5, 2019 8:13:49 AM by Hibernate Tools 3.2.2.GA


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Authorities generated by hbm2java
 */
@Entity
@Table(name="authorities"
)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.StringIdGenerator.class,
		property="authorityId")
public class Authorities  implements java.io.Serializable {


	 private Integer id;
	 private Users users;
	 private String username;
	 private String authority;

	public Authorities() {
	}

	public Authorities(Users users, String username, String authority) {
	   this.users = users;
	   this.username = username;
	   this.authority = authority;
	}
   
	 @Id @GeneratedValue(strategy=IDENTITY)
	
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_id", nullable=false)
	public Users getUsers() {
		return this.users;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@Column(name="username", nullable=false, length=60)
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="authority", nullable=false, length=45)
	public String getAuthority() {
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}




}


