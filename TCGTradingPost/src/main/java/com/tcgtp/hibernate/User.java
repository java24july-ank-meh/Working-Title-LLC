package com.tcgtp.hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	private long userID;
	private String username;
	private String password;
	private String email;
	private int locked;
	private int userroleID; // 1 = customer, 2 = employee
	
	// Constructors
	public User() {
		super();
	}
	public User(String username, String password, String email, int userroleID) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.locked = 0;
		this.userroleID = userroleID;
	}
	
	// Getters and Setters
	public void setUserID(long customerID) {
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
	public void setLocked(int locked) {
		this.locked = locked;
	}
	public void setUserroleID(int userroleID) {
		this.userroleID = userroleID;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_USER_ID_GEN")
	@Column(name="userID")
	public long getUserID() {
		return userID;
	}
	
	@Column(name="username", unique=true, nullable=false, length=30)
	public String getUsername() {
		return username;
	}
	
	@Column(name="password", nullable=false, length=30)
	public String getPassword() {
		return password;
	}
	
	@Column(name="email", unique=true, nullable=false, length=60)
	public String getEmail() {
		return email;
	}
	
	@Column(name="locked", nullable=false)
	public int isLocked() {
		return locked;
	}
	
	@Column(name="userroleID", nullable=false)
	public int getUserroleID() {
		return userroleID;
	}
	
	
}
