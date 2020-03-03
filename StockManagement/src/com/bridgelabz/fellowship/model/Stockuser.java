package com.bridgelabz.fellowship.model;

public class Stockuser {
	// Users model
	String username;
	int share;

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Username: " + getUsername() + "\nTotal shares: " + getShare();
	}

}
