package com.interview.company.zenpayroll;

import java.util.Calendar;

public class Company {
	private String name;
	private int id;
	private Calendar joinDate;
	private float balance;
	
	public Company() {
		
	}
	
	public Company(String name, int id, Calendar joinDate, float balance) {
		this.name = name;
		this.id = id;
		this.joinDate = joinDate;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
}
