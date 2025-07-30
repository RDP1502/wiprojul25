package com.wipro.hibernatedemo;
import java.util.List;
import java.util.Scanner;

import com.wipro.hibernatedemo.entity.PanDetails;
import com.wipro.hibernatedeom.panrepo.PanOperation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  
    	
    	int choice=0;
    	do {
    	System.out.println("--Menu---");
    	System.out.println("1.--Create Pan---");
    	System.out.println("2.--Find by Pan Id ---");
    	System.out.println("3.--Update Pan---");
    	System.out.println("4.--Delete by Pan id---");
    	System.out.println("5.--Find All Pan---");
    	System.out.println("9.--Exit---");
    	Scanner sc= new Scanner(System.in);    	
    	  choice= sc.nextInt();
    	  
    	
	    	switch(choice)
	    	{
	    		case 1:
	    			PanOperation.createPan();
	    		break;
	    		case 2:
	    			System.out.println("Please enter pan id:");
	    			int id= sc.nextInt();
	    			PanDetails m=PanOperation.findById(id);
	    			System.out.println(m);
	    			break;
	    			
	    		case 3:
	    			PanOperation.updatePan();
	    			break;
	    			
	    		case 4:
	    			 
	    			System.out.println("Please enter pan id:");
	    			int id1= sc.nextInt();
	    			PanOperation.deleteById(id1);
	    			break;
	    			
	    		case 5:
	    			List<PanDetails> list=PanOperation.findAll();
	    			System.out.println(list);
	    			break;
	    		case 7:
	    			System.out.println("Please enter Pan Holder Name");
	    			String name=sc.next();
	    			List<PanDetails> listPans= PanOperation.findByPanHolderName(name);
	    			System.out.println(listPans);
	    			break;
	    		case 9:
	    			System.out.println("Exited...");
	    			return;
	    		
	    		default:
	    			System.out.println("Invalid option please try again");
	    			break;
	    	
	    	 }
 
    	}while(choice!=9);
    }
    }

