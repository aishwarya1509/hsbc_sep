package com.Exam.entity;

public class ExamFoodItem extends ExamProduct{
	private String Date_of_Manufacture;
	private String Date_of_Expiry;
	private String Vegetarian;
	public String getDate_of_Manufacture() {
		return Date_of_Manufacture;
	}
	public void setDate_of_Manufacture(String date_of_Manufacture) {
		Date_of_Manufacture = date_of_Manufacture;
	}
	public String getDate_of_Expiry() {
		return Date_of_Expiry;
	}
	public void setDate_of_Expiry(String date_of_Expiry) {
		Date_of_Expiry = date_of_Expiry;
	}
	public String getVegetarian() {
		return Vegetarian;
	}
	public void setVegetarian(String vegetarian) {
		Vegetarian = vegetarian;
	}
	
	
	
}
