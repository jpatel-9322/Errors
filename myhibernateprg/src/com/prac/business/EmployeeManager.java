package com.prac.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.prac.model.Employee;

public class EmployeeManager {
	
	private SessionFactory factory;

	public EmployeeManager(){
		 try {
			 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .configure("hibernate.cfg.xml").build();
	 
	            // Create a metadata sources using the specified service registry.
	            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
	 
	            factory =  metadata.getSessionFactoryBuilder().build();
	         
			 
	     } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	}

	
	public List<Employee> getData(){
		System.out.println("Getting the Employee data");
		List<Employee> empList = new ArrayList<>();
		Transaction tx;
		if(factory!=null){
			Session session = factory.openSession();
			tx = session.beginTransaction();
			try{
				List empListTemp = session.createQuery("From Employee").list();
				Iterator iterator = empListTemp.iterator();
				while(iterator.hasNext()){
					Employee emp = (Employee)iterator.next();
					empList.add(emp);
				}
				tx.commit();
			}catch(Exception ex){
				ex.printStackTrace();
				tx.rollback();
			}finally {
				session.close();
			}
		}
		return empList;
	}
	
	
	public int addData(String name, String empContactNumber, String mailId){
		System.out.println("Adding the Employee");
		Employee emp = new Employee(name, mailId, empContactNumber);
		Transaction tx = null;
		Integer employeeID = 0;
		Session session = null;
		try{
		if(factory!=null){
			session = factory.openSession();
			tx = session.beginTransaction();
			employeeID = (Integer)session.save(emp);
			
			
			
			System.out.println("The last ID generated is [ " + employeeID + " ]");
			tx.commit();
		}}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		return employeeID;
	}
}
