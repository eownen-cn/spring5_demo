package org.denny.spring.tx.entity;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username ; // 账户名称
	private double balance ; // 账户余额

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public final double getBalance() {
		return balance;
	}

	public final void setBalance(double balance) {
		this.balance = balance;
	}
	
}
