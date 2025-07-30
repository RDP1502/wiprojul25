package com.wipro.springdemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springdemo.beans.Department;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
    	 Department dept=  ctx.getBean(Department.class);
     	 dept.setDeptCode("Fin");
     	 dept.setDeptName("Finance");
     	System.out.println(dept);
    }
}
