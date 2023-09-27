package com.example.courseTrackingSystem.modelsDto;

import java.util.Date;

public class CourseRatingDto {
	private int id;
	private String username;
	private int rating;
	private Date timeRating;
	
	public CourseRatingDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTimeRating() {
		return timeRating;
	}

	public void setTimeRating(Date timeRating) {
		this.timeRating = timeRating;
	}
	
	
}
