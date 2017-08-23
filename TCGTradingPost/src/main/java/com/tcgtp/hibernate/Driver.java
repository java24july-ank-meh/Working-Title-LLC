package com.tcgtp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Driver {

	public static void main(String[] args) {
		
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx2 = session.beginTransaction();
			Inventory item = new Inventory("Storm Crow", "Magic The Gathering", 83282);
			session.save(item);
			session.flush();
			tx2.commit();
			
			Transaction tx1 = session.beginTransaction();
			Customer user = new Customer("vcommero", "p4ssw0rd", "vacommero@yahoo.com");
			session.save(user);
			session.flush();
			tx1.commit();
			
			
			
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
