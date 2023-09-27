package com.example.courseTrackingSystem.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_ratings")
public class CourseRatings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "id_course")
	private Course course;
	@Column
	private int rating;
	
	@ManyToOne
    @JoinColumn(name = "id_student")
	private Student student;
	@Column(name = "time_rating")
	private Date timeRating;
	
	public CourseRatings() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "CourseRatings [id=" + id + ", course=" + course + ", rating=" + rating + ", student=" + student
				+ ", timeRating=" + timeRating + "]";
	}	
	
	
	
}
