package com.bridgelabz.felloship.model;

public class Stocks {
	// company model
	public String companysymbol;
	public String companyname;
	public int companyavailableshare;
	public int shareprice;

	public String getCompanysymbol() {
		return companysymbol;
	}

	public void setCompanysimbol(String companysymbol) {
		this.companysymbol = companysymbol;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public int getCompanyavailableshare() {
		return companyavailableshare;
	}

	public void setCompanyavailableshare(int i) {
		this.companyavailableshare = i;
	}

	public int getShareprice() {
		return shareprice;
	}

	public void setShareprice(int shareprice) {
		this.shareprice = shareprice;
	}

}
