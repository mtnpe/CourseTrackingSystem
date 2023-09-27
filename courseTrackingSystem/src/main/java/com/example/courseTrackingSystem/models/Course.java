package com.example.courseTrackingSystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "name_course")
	private String nameCourse;
	@Column (name = "time_start")
	private Date timeStart;
	@Column
	private String duration;
	@Column
	private int fees;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_instructor",  referencedColumnName = "id")
	private Instructor instructor;	

	@ManyToMany(mappedBy = "courses")
    private List<Student> students  = new ArrayList<>();;

	@JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseRatings> courseRatings = new ArrayList<>();
    
	public Course() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<CourseRatings> getCourseRatings() {
		return courseRatings;
	}

	public void setCourseRatings(List<CourseRatings> courseRatings) {
		this.courseRatings = courseRatings;
	}
	
	public void removeStudents(Student student) {
		this.students.remove(student);
		student.getCourses().remove(this);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", nameCourse=" + nameCourse + ", timeStart=" + timeStart + ", duration=" + duration
				+ ", fees=" + fees + ", instructor=" + instructor + "]";
	}


	
		
}
