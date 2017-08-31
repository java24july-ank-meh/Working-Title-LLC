package com.tcgtp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tcgtp.domain.Inventory;
import com.tcgtp.domain.Role;
import com.tcgtp.domain.User;
import com.tcgtp.services.InventoryService;
import com.tcgtp.services.RoleService;
import com.tcgtp.services.UserService;

//@Component
public class InitialDatabaseLoading implements ApplicationListener<ContextRefreshedEvent>{

	
	private UserService userService;
	private RoleService roleService;
	private InventoryService inventoryService;
	
	private Logger log = Logger.getLogger(InitialDatabaseLoading.class);
	
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
	
	@Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
	
	@Autowired
    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
	
	
	// The primary method that executes when the application starts
	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		createRoles();
		createUsers();
		
		assignRoles();
		
		addInventory();
		
		addNorasSpecialTestingThings();
	}


	//I use these a lot in my tests so I added them here to avoid a lot of code rewriting.
	private void addNorasSpecialTestingThings() {
		User testSparkle = new User();
		
		List<Role> testRoles = new ArrayList<Role>();
		Role r = new Role();
		r.setRoleName("Princess");
		
		roleService.saveOrUpdate(r);
		
		testRoles.add(r);
		
		testSparkle.setUsername("FriendshipPrincess");
		testSparkle.setPassword("HelloThere");
		testSparkle.setEmail("friendship@equestria.gov");
		testSparkle.setEncryptedPassword("This is totally encrypted");
		testSparkle.setRoles(testRoles);
		
		userService.saveOrUpdate(testSparkle);
		
	}

	private void addInventory() {
		Inventory item1 = new Inventory();
		item1.setCardName("Pikachu");
		item1.setCardID("bw11-RC7");
		item1.setSetName("Legendary Treasures");
		item1.setGame("Pokemon");
		item1.setPrice(new BigDecimal(12.50));
		item1.setStock(3);
		Inventory item2 = new Inventory();
		item2.setCardName("Counterspell");
		item2.setCardID("413585");
		item2.setSetName("Eternal Masters");
		item2.setGame("Magic the Gathering");
		item2.setPrice(new BigDecimal(2.50));
		item2.setStock(10);
		Inventory item3 = new Inventory();
		item3.setCardName("Sol Ring");
		item3.setCardID("405389");
		item3.setSetName("Commander 2015");
		item3.setGame("Magic the Gathering");
		item3.setPrice(new BigDecimal(3.10));
		item3.setStock(5);
		
		List<Inventory> inv = new ArrayList<>();
		
		inv.add(item1);
		inv.add(item2);
		inv.add(item3);
		
		for (Inventory i : inv) {
			inventoryService.saveOrUpdate(i);
		}
		
		log.info("Inventory saved!");
		
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
