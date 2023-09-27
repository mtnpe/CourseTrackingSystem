package com.example.courseTrackingSystem.modelsDto;

import java.util.Date;

public class CourseWithInstructorDto {
	private int id;
	private String nameInstructor;
	private String nameCourse;
	private Date timeStart;
	private String duration;
	private int fees;
	
	public CourseWithInstructorDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameInstructor() {
		return nameInstructor;
	}

	public void setNameInstructor(String nameInstructor) {
		this.nameInstructor = nameInstructor;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
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
	
	
}
