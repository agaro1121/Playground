package springJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CompanyRSExtractor implements ResultSetExtractor {

	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Company> result = new LinkedList<Company>();
		
		while(rs.next()){
		Company company = new Company();
		company.setCompany_id(rs.getString("company_id"));
		company.setName(rs.getString("name"));
		company.setPlace_id(rs.getString("place_id"));
		company.setStock_id(rs.getString("stock_id"));
		result.add(company);
		}
		
	
		
		return result;
	}

}
