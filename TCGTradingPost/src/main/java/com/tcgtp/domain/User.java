package com.tcgtp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TCGTPUSERS")
public class User {

	private Long userID;
	private String username;
	@Transient
	private String password;
	private String encryptedPassword;
	private String email;
	private Boolean enabled = true;
	private List<Role> roles = new ArrayList<>();
	
	// Constructors
	public User() {
		super();
	}
	
	// gives the user a role
	public void addRole(Role role){
        if(!this.roles.contains(role)){
        	
            this.roles.add(role);
            
        }

        if(!role.getUsers().contains(this)){
        	
            role.getUsers().add(this);
            
        }
	}
	
	// removes a role from the user
	public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
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
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_USER_ID")
	@SequenceGenerator(name="SQ_USER_ID", sequenceName="SQ_USER_ID")
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
	@Column(name="encryptedPassword", nullable=false)
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	@Column(name="email", unique=true, nullable=false)
	public String getEmail() {
		return email;
	}
	@Column(name="enabled", nullable=false)
	public Boolean getEnabled() {
		return enabled;
	}
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERROLES", joinColumns = @JoinColumn(name = "userID"),
		inverseJoinColumns = @JoinColumn(name = "roleID"))
    @Column(name="roles")
    public List<Role> getRoles() {
		return roles;
	}
	
	
	
}
