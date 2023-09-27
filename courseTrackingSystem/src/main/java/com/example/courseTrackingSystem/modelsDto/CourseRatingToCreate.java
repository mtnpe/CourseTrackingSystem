package com.example.courseTrackingSystem.modelsDto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_ratings")
public class CourseRatingToCreate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "id_course")
	private int idCourse;
	@Column
	private int rating;
	@Column(name = "id_student")
	private int idStudent;
	@Column(name = "time_rating")
	private Date timeRating;
	
	public CourseRatingToCreate(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public Date getTimeRating() {
		return timeRating;
	}

	public void setTimeRating(Date timeRating) {
		this.timeRating = timeRating;
	}

	@Override
	public String toString() {
		return "CourseRatingToCreate [id=" + id + ", idCourse=" + idCourse + ", rating=" + rating + ", idStudent="
				+ idStudent + ", timeRating=" + timeRating + "]";
	}
	
	
	
}
