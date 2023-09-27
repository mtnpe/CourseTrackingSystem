package com.example.courseTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.Course;
import com.example.courseTrackingSystem.models.CourseRatings;
import com.example.courseTrackingSystem.models.Instructor;
import com.example.courseTrackingSystem.models.Student;
import com.example.courseTrackingSystem.modelsDto.CourseDto;
import com.example.courseTrackingSystem.modelsDto.CourseRatingDto;
import com.example.courseTrackingSystem.modelsDto.CourseWithRatingsDto;
import com.example.courseTrackingSystem.repository.CourseDtoRepository;
import com.example.courseTrackingSystem.repository.CourseRepository;
import com.example.courseTrackingSystem.repository.InstructorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseDtoRepository courseDtoRepository;
	
	@Autowired 
	private InstructorRepository instructorRepository;
	
	public List<CourseWithRatingsDto> getCourse(){
		List<CourseWithRatingsDto> newCourses = new ArrayList<>();
		List<Course> courses = courseRepository.findAll();
		for (Course course: courses) {
			CourseWithRatingsDto newCourse = new CourseWithRatingsDto();
			newCourse.setId(course.getId());
			newCourse.setInstructor(course.getInstructor().getName());
			newCourse.setNameCourse(course.getNameCourse());
			newCourse.setTimeStart(course.getTimeStart());
			newCourse.setDuration(course.getDuration());
			newCourse.setFees(course.getFees());
			List<CourseRatingDto> newCourseRating = new ArrayList<>();
			List<CourseRatings> courseRating = course.getCourseRatings();
			for (CourseRatings cr: courseRating) {
				CourseRatingDto newCR = new CourseRatingDto();
				newCR.setId(cr.getId());
				newCR.setUsername(cr.getStudent().getUsername());
				newCR.setRating(cr.getRating());
				newCR.setTimeRating(cr.getTimeRating());
				newCourseRating.add(newCR);
			}
			newCourse.setCourseRatings(newCourseRating);
			newCourses.add(newCourse);
		}
		
		return newCourses;
	}
	
	public void addCourse(CourseDto courseDto) {
		Instructor instructor = new Instructor();
		instructor = instructorRepository.findById(courseDto.getIdInstructor());
		if (instructor != null) {
			courseDtoRepository.save(courseDto);
		} else {
			throw new EntityNotFoundException("instructor not found");
		}
	}
	
	public void updateCourse(int id, CourseDto course) {
		course.setId(id);
		Instructor instructor = new Instructor();
		instructor = instructorRepository.findById(course.getIdInstructor());
		if (instructor != null) {
			courseDtoRepository.save(course);
		} else {
			throw new EntityNotFoundException("instructor not found");
		}
	}
	
	public void deleteCourse(int id) {
		Course course = courseRepository.findById(id);
		List<Student> existingStudents = new ArrayList<>(course.getStudents());
		for (Student student : existingStudents) {
			course.removeStudents(student);
		}
		courseRepository.delete(course);
	}
}
