package com.tut.Hibernate_config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
 
public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		Session session= sessionFactory.openSession();
		
		Employee employee = new Employee();
		employee.setId(3);
		employee.setMail("shivu@gmail.com");
		employee.setName("shivaism");
		employee.setSalary(100000);
		
		Transaction transaction= session.getTransaction();
		transaction.begin();
		//session.save(employee);
		Employee emp=session.get(Employee.class,3);
		//emp.setName("updated_name");
		//emp.setMail("updated@gmail.com");
		//System.out.println(emp);
		session.delete(emp);
		transaction.commit();
	}
}
