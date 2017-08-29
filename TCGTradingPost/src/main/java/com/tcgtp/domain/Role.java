package com.tcgtp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Entity
@Table(name="ROLES")
public class Role {

	private Long roleID;
	private String role;
	private List<User> users = new ArrayList<>();
	
	public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }

        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }

    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
}
	
	public void setId(Long roleID) {
		this.roleID = roleID;
	}
	public void setRoleName(String roleName) {
		this.role = roleName;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="roleID")
	public Long getId() {
		return roleID;
	}
	@Column(name="role")
	public String getRoleName() {
		return role;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "USERROLES", joinColumns = @JoinColumn(name = "roleID"),
		inverseJoinColumns = @JoinColumn(name = "userID"))
	public List<User> getUsers(){
		return users;
	}
	
	
	
	
	
	
}
