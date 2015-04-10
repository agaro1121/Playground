package springJDBC;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class CompanyDAO {
	private JdbcTemplate jt = null;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public Company getCompany(String id) {
		String sql = "select * from company where company_id = ?";
		
		
		return getJt().queryForObject(sql, new Object[]{Integer.parseInt(id)}, new CompanyRowMapper());
	}

	public List<Company> getCompanies(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Company> getAllCompanies() {
		RowMapper mapper = new CompanyRowMapper();
		String sql = "select * from company";
		
		return getJt().query(sql, new CompanyRSExtractor());
//		return getJt().query(sql, new RowMapperResultSetExtractor(mapper,1));
	}

	public void insertCompany(Company c) {
		// TODO Auto-generated method stub

	}

	public void updateCompany(Company c) {
		// TODO Auto-generated method stub

	}

	public void deleteCompany(Company c) {
		// TODO Auto-generated method stub

	}

	public void deleteAllCompanies() {
		// TODO Auto-generated method stub

	}

}
