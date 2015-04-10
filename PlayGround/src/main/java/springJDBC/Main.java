package springJDBC;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	private static List<Company> r;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/SpringConfig.xml");
		CompanyDAO test = (CompanyDAO)context.getBean("companyDAO");
		List<Company> tl = new ArrayList<Company>();
		
//		Company co = test.getCompany("8");
		tl = test.getAllCompanies();
		r = test.getAllCompanies();
		
		String tlr = (tl.isEmpty()) ? "Yes":"No";
		String rr = (tl.isEmpty()) ? "Yes":"No";
		
		System.out.println("Company List tl empty? " + tlr + " size " + tl.size());
		System.out.println("Company List r empty? " + rr + " size " + r.size());
//		System.out.println(co.getCompany_id());
//		System.out.println(co.getName());
//		System.out.println(co.getPlace_id());
//		System.out.println(co.getStock_id());
		
	}

}
