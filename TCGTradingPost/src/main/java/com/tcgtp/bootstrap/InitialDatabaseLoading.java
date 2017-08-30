package com.tcgtp.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tcgtp.domain.Role;
import com.tcgtp.domain.User;
import com.tcgtp.repositories.InventoryRepository;
import com.tcgtp.repositories.OrderStatusRepository;
import com.tcgtp.services.RoleService;
import com.tcgtp.services.UserService;

@Component
public class InitialDatabaseLoading implements ApplicationListener<ContextRefreshedEvent>{

	
	private UserService userService;
	private RoleService roleService;
	
	private Logger log = Logger.getLogger(InitialDatabaseLoading.class);
	
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
	
	@Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
	
	
	// The primary method that executes when the application starts
	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		createRoles();
		createUsers();
		
		assignRoles();
	}


	private void createUsers() {
		User user1 = new User();
		user1.setUsername("vcommero");
		user1.setPassword("p4ssw0rd");
		user1.setEmail("vcommero@yahoo.com");
		User user2 = new User();
		user2.setUsername("danyStormborn");
		user2.setPassword("DRAGONS");
		user2.setEmail("dragons@dragons.net");
		User user3 = new User();
		user3.setUsername("hodor");
		user3.setPassword("hodor");
		user3.setEmail("hodor@hodor.com");
		User user4 = new User();
		user4.setUsername("hunter");
		user4.setPassword("BURNINATE");
		user4.setEmail("hichelt@gmail.com");
		
		List<User> userArr = new ArrayList<>();
		userArr.add(user1);
		userArr.add(user2);
		userArr.add(user3);
		userArr.add(user4);
		
		for (User usr : userArr) {
			userService.saveOrUpdate(usr);
		}
		
		log.info("Saved users!");
	}

	private void createRoles() {
		Role customerRole = new Role();
		customerRole.setRoleName("CUSTOMER");
		roleService.saveOrUpdate(customerRole);
		
		Role employeeRole = new Role();
		employeeRole.setRoleName("EMPLOYEE");
		roleService.saveOrUpdate(employeeRole);
		
		log.info("Saved roles!");
	}
	
	private void assignRoles() {
		List<Role> rolesList = (List<Role>) roleService.listAll();
		List<User> usersList = (List<User>) userService.listAll();
		
		for (User usr : usersList) {
			if (usr.getUsername().equals("vcommero")) {
				usr.addRole(rolesList.get(1));
			} else {
				usr.addRole(rolesList.get(0));
			}
			userService.saveOrUpdate(usr);
		}
	}
	
	
}
