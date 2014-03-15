package hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springJDBC.CompanyDAO;

public class Main {

	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyDAO test = (CompanyDAO)context.getBean("companyDAO2");
		
		test.getCompany("10");
		
	}
	
	
}
