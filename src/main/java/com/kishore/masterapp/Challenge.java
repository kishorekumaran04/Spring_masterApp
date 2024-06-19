package com.kishore.masterapp;

public class Challenge {
	
	private Long id;
	private String month;
	private String description;
	
	//Constructor
	public Challenge(Long id, String month, String description) {
		super();
		this.id = id;
		this.month = month;
		this.description = description;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
