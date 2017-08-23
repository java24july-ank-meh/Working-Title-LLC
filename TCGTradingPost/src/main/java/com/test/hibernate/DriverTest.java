package com.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tcgtp.hibernate.Customer;

public class DriverTest {

	public static void main(String[] args) {

		try {
			// session factory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			// session
			Session session = sf.openSession();
			
			//Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			// transaction
			Transaction tx = session.beginTransaction();
			
			// persist person object
			Customer person = new Customer(0, "NekoGirl", "HelloThere", "nothing@example.com");
			
			// Insert
			session.save(person);
			
			// Flush
			session.flush();
			
			// commit
			tx.commit();
			
			// close session;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
