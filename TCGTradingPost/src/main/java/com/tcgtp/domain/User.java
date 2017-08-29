package com.tcgtp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Transient
    private String password;

    private String encryptedPassword;
    private Boolean enabled = true;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles = new ArrayList<>();
    private Integer failedLoginAttempts = 0;
    
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(Long userID, String username, String password, String email, Integer locked, Integer userroleID) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.locked = locked;
		this.userroleID = userroleID;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	private String email;
	private Integer locked;
	private Integer userroleID; // 1 = customer, 2 = employee
	
	
	
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
	
	public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }

        if(!role.getUsers().contains(this)){
            role.getUsers().add(this);
        }
    }

    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
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