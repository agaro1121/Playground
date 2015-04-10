package springJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CompanyRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Company company = new Company();
		company.setCompany_id(rs.getString("company_id"));
		company.setName(rs.getString("name"));
		company.setPlace_id(rs.getString("place_id"));
		company.setStock_id(rs.getString("stock_id"));
		
		return company;
	}

}
