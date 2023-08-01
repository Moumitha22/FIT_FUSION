package Fit_Fusion.classes;

import java.sql.Date;

public class FoodLog {
	private int id;
	private Date date;
	private String name;
	private int calories;
	private int userId;
	public FoodLog(Date date, String name,int calories, int userId) {
		super();
		this.date = date;
		this.calories = calories;
		this.userId = userId;
	}
	public FoodLog() {
		// TODO Auto-generated constructor stub
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
