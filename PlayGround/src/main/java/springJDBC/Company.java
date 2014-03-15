package springJDBC;

public class Company {
	private String company_id;
	private String name;
	private String place_id;
	private String stock_id;
	

	public String getName() {
		return name;
	}
	public String getPlace_id() {
		return place_id;
	}
	public String getStock_id() {
		return stock_id;
	}

	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
}
