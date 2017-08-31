package com.tcgtp.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Driver {

	public static void main(String[] args) {
		
		try {
			//Session Factory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			//Session
			Session session = sf.openSession();
			
			//Transaction
			Transaction tx = session.beginTransaction();
			
			//Persist person object
			User testSparkle = new User();
			
			List<Role> testRoles = new ArrayList<Role>();
			Role r = new Role();
			r.setRoleName("Princess");
			
			session.save(r);
			
			
			List<Role> roles = session.createCriteria(Role.class).list();
			
			for(Role rollington : roles) {
				testRoles.add(rollington);
			}
			
			testSparkle.setUsername("FriendshipPrincess");
			testSparkle.setPassword("HelloThere");
			testSparkle.setEmail("friendship@equestria.gov");
			testSparkle.setEncryptedPassword("This is totally encrypted");
			testSparkle.setRoles(testRoles);
			
			
			//Insert
			session.save(testSparkle);
			
			//Flush
			session.flush();
			
			//Commit
			tx.commit();
			
			//close session
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
