package com.example.courseTrackingSystem.modelsDto;

import java.util.ArrayList;
import java.util.List;

public class StudentWithCoursesDto {
	private int id;
	private String username;
	private List<CourseWithInstructorDto> courses = new ArrayList<>();
	
	public StudentWithCoursesDto() {}

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

	public List<CourseWithInstructorDto> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseWithInstructorDto> courses) {
		this.courses = courses;
	}
	
}
