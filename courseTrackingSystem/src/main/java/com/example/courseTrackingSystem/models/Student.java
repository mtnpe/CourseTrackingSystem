package com.example.courseTrackingSystem.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String pass;
	@OneToOne(mappedBy = "student")

    @JoinColumn(name = "id_student", referencedColumnName = "id")
	private StudentDetail studentDetail;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "enrollments",
        joinColumns = @JoinColumn(name = "id_student"),
        inverseJoinColumns = @JoinColumn(name = "id_course")
    )
    private List<Course> courses  = new ArrayList<>();;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<CourseRatings> courseRatings  = new ArrayList<>();

	public Student() {
	}

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<CourseRatings> getCourseRatings() {
		return courseRatings;
	}

	public void setCourseRatings(List<CourseRatings> courseRatings) {
		this.courseRatings = courseRatings;
	}
	
	public void removeCourses(Course course) {
		this.courses.remove(course);
		course.getStudents().remove(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", pass=" + pass + ", studentDetail=" + studentDetail
				+ "]";
	}
	
	

}
