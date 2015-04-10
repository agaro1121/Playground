package springJDBC;

import java.util.List;

public interface ICompanyDAO {
	public Company getCompany(String id);
	public List<Company> getCompanies(String sql);
	public List<Company> getAllCompanies();
	public void insertCompany(Company c);
	public void updateCompany(Company c);
	public void deleteCompany(Company c);
	public void deleteAllCompanies();
}
