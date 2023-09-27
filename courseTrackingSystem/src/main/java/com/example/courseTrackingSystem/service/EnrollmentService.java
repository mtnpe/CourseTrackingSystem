package com.example.courseTrackingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.Course;
import com.example.courseTrackingSystem.models.Enrollments;
import com.example.courseTrackingSystem.models.Student;
import com.example.courseTrackingSystem.modelsDto.EnrollmentDto;
import com.example.courseTrackingSystem.repository.CourseRepository;
import com.example.courseTrackingSystem.repository.EnrollmentDtoRepository;
import com.example.courseTrackingSystem.repository.EnrollmentsRepository;
import com.example.courseTrackingSystem.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnrollmentService {
	@Autowired
	private EnrollmentDtoRepository enrollmentDtoRepository;
	@Autowired
	private EnrollmentsRepository enrollmentsRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	public void addEnrollment(EnrollmentDto enrollmentDto) {
		Course course = courseRepository.findById(enrollmentDto.getIdCourse());
		Student student = studentRepository.findById(enrollmentDto.getIdStudent());
		if (course != null && student != null) {
			enrollmentDtoRepository.save(enrollmentDto);
		}
		else {
        throw new EntityNotFoundException("Course or Student not found");
        }   
	}
	
	public void updateEnrollment(int id, Enrollments enrollment) {
		Enrollments newEnrollment = enrollmentsRepository.findById(id);
		newEnrollment.setEnrollDate(enrollment.getEnrollDate());
		enrollmentsRepository.save(newEnrollment);
	}
	
}
