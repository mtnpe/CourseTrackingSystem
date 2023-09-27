package com.example.courseTrackingSystem.modelsDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseWithRatingsDto {
	private int id;
	private String nameCourse;
	private String instructor;
	private Date timeStart;
	private String duration;
	private int fees;

    private List<CourseRatingDto> courseRatings = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public List<CourseRatingDto> getCourseRatings() {
		return courseRatings;
	}

	public void setCourseRatings(List<CourseRatingDto> courseRatings) {
		this.courseRatings = courseRatings;
	}
	
    
    

}
