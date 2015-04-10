package hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CompanyRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Company company = new Company();
		company.setCOMPANY_ID(rs.getString("company_id"));
		company.setNAME(rs.getString("name"));
		company.setPLACE_ID(rs.getString("place_id"));
		company.setSTOCK_ID(rs.getString("stock_id"));
		
		return company;
	}

}
