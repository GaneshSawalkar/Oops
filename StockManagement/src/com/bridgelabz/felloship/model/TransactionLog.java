package com.bridgelabz.felloship.model;

import java.util.Date;

public class TransactionLog {
	// Transaction model
	String transction;
	String username;
	String companysymbol;
	String companyname;
	int companyshares;
	int shareprice;
	Date date;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompanysymbol() {
		return companysymbol;
	}

	public void setCompanysymbol(String companysymbol) {
		this.companysymbol = companysymbol;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public int getCompanyshares() {
		return companyshares;
	}

	public void setCompanyshares(int companyshares) {
		this.companyshares = companyshares;
	}

	public int getShareprice() {
		return shareprice;
	}

	public void setShareprice(int shareprice) {
		this.shareprice = shareprice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransction() {
		return transction;
	}

	public void setTransction(String transction) {
		this.transction = transction;
	}

}
