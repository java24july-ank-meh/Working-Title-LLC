package com.tcgtp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
		name="SQ_USER_ID_GEN",
		sequenceName="SQ_USER_ID_GEN",
		initialValue=2000000,
		allocationSize=1
		)
@Table(name="TCGTPUSERS")
public class User {

	private Long userID;
	private String username;
	private String password;
	private String email;
	private Integer locked;
	private Integer userroleID; // 1 = customer, 2 = employee
	
	// Constructors
	public User() {
		super();
	}
	public User(String username, String password, String email, Integer userroleID) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.locked = 0;
		this.userroleID = userroleID;
	}
	
	// Getters and Setters
	public void setUserID(Long customerID) {
		this.userID = customerID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public void setUserroleID(Integer userroleID) {
		this.userroleID = userroleID;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SQ_USER_ID_GEN")
	@Column(name="userID")
	public Long getUserID() {
		return userID;
	}
	@Column(name="username", unique=true, nullable=false)
	public String getUsername() {
		return username;
	}
	@Column(name="password", nullable=false)
	public String getPassword() {
		return password;
	}
	@Column(name="email", unique=true, nullable=false)
	public String getEmail() {
		return email;
	}
	@Column(name="locked", nullable=false)
	public Integer isLocked() {
		return locked;
	}
	
	@Column(name="userroleID", nullable=false)
	public Integer getUserroleID() {
		return userroleID;
	}
	
	
}
