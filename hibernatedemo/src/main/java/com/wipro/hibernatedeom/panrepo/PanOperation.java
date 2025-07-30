package com.wipro.hibernatedeom.panrepo;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.hibernate.util.Hibernate;
import com.wipro.hibernatedemo.entity.PanDetails;

public class PanOperation {
	 public static void updatePan()
	    {
	    	
	    	Scanner sc= new Scanner(System.in); 
	    	
	    	System.out.println("Please enter your unique id");
	    	int id= sc.nextInt();
	    	System.out.println("Please enter your name");
	    	String panHolderName= sc.next();
	    	System.out.println("Please enter pan number");
	    	String panNumber= sc.next();
	    	PanDetails m= new PanDetails(id,panHolderName,panNumber);
	    	save(m);
	    }
	    
	 public static void createPan()
	    {
	    	Scanner sc= new Scanner(System.in); 
	    	
	    	System.out.println("Please enter your name");
	    	String panHolderName= sc.next();
	    	System.out.println("Please enter pan number");
	    	String panNumber= sc.next();
	    	PanDetails p= new PanDetails(panHolderName,panNumber);
	    	save(p);
	    	
	    	
	    }
	    //insert and update
	 public static void save(PanDetails p)
	    {
	    	Session session= Hibernate.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	
	    	if(p.getId()!=0)//update
	    	{
	    		PanDetails m1=findById(p.getId());
	    		m1.setPanHolderName(p.getPanHolderName());
	    		m1.setPanNumber(p.getPanNumber());
	    		session.persist(m1);
	    	}
	    	else {//insert
	    	   	session.persist(p);
	    	}
	    	transaction.commit();     	
	    	
	    }
	    
	 public static PanDetails findById(int id)
	    {
	     	Session session= Hibernate.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	PanDetails m=session.find(PanDetails.class, id);
	    	return m;
	    	
	    }
	    
	 public static PanDetails deleteById(int id)
	    {
	     	Session session= Hibernate.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	PanDetails p=session.find(PanDetails.class, id);
	    	session.remove(p);
	    	transaction.commit();
	    	return p;
	    	
	    }
	    
	 public static List<PanDetails> findAll()
	    {
	    	Session session= Hibernate.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="from PanDetails";//select * from movie
	    	Query query=session.createQuery(hqlQuery);
	    	List<PanDetails> list=query.list();
	    	return list;
	    	
	    	
	    	
	    }
	    
	    
	 public static List<PanDetails> findByPanHolderName(String panHolderName)
	    {
	    	Session session= Hibernate.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="from PanDetails where panHolderName=:mHolderName";//select *  from movie where movie_language=''
	    	Query query=session.createQuery(hqlQuery,PanDetails.class);
	    	query.setParameter("pHolderName",panHolderName);
	    	List<PanDetails> list=query.list();
	    	return list;   	
	    	
	    	
	    }
	
	

}
