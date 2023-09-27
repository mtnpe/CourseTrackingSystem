package com.example.courseTrackingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.Course;
import com.example.courseTrackingSystem.models.Student;
import com.example.courseTrackingSystem.modelsDto.CourseRatingToCreate;
import com.example.courseTrackingSystem.repository.CourseRatingToCreateRepository;
import com.example.courseTrackingSystem.repository.CourseRepository;
import com.example.courseTrackingSystem.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseRatingToCreateService {
	@Autowired
	private CourseRatingToCreateRepository courseRatingToCreateRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	public void addRating(CourseRatingToCreate courseRatingToCreate) {
		Course course = courseRepository.findById(courseRatingToCreate.getIdCourse());
		Student student = studentRepository.findById(courseRatingToCreate.getIdStudent());
		if (course != null && student != null) {
			courseRatingToCreateRepository.save(courseRatingToCreate);
		}
		else {
        throw new EntityNotFoundException("Course or Student not found");
        }    
	}

	public void deleteRating(int id) {
		courseRatingToCreateRepository.deleteById(id);
	}
}
