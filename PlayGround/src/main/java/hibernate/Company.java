package hibernate;

public class Company {

	String COMPANY_ID;
	String NAME;
	String PLACE_ID;
	String STOCK_ID;
	
	public String getCOMPANY_ID() {
		return COMPANY_ID;
	}
	public void setCOMPANY_ID(String cOMPANY_ID) {
		COMPANY_ID = cOMPANY_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPLACE_ID() {
		return PLACE_ID;
	}
	public void setPLACE_ID(String pLACE_ID) {
		PLACE_ID = pLACE_ID;
	}
	public String getSTOCK_ID() {
		return STOCK_ID;
	}
	public void setSTOCK_ID(String sTOCK_ID) {
		STOCK_ID = sTOCK_ID;
	}
	
}
