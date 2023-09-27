package com.example.courseTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.Course;
import com.example.courseTrackingSystem.models.Student;
import com.example.courseTrackingSystem.modelsDto.CourseWithInstructorDto;
import com.example.courseTrackingSystem.modelsDto.StudentWithCoursesDto;
import com.example.courseTrackingSystem.repository.CourseRepository;
import com.example.courseTrackingSystem.repository.StudentDetailRepository;
import com.example.courseTrackingSystem.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentDetailRepository studentDetailRepository;
	
	public List<StudentWithCoursesDto> getStudent(){
		List<StudentWithCoursesDto> newStudents = new ArrayList<>();
		List<Student> students = studentRepository.findAll();
		for (Student stu: students) {
			StudentWithCoursesDto newStu = new StudentWithCoursesDto();
			newStu.setId(stu.getId());
			newStu.setUsername(stu.getUsername());
			List<CourseWithInstructorDto> newCourses = new ArrayList<>();
			List<Course> courses = stu.getCourses();
			for (Course c: courses) {
				CourseWithInstructorDto newC = new CourseWithInstructorDto();
				newC.setId(c.getId());
				newC.setNameCourse(c.getNameCourse());
				newC.setNameInstructor(c.getInstructor().getName());
				newC.setDuration(c.getDuration());
				newC.setTimeStart(c.getTimeStart());
				newC.setFees(c.getFees());
				newCourses.add(newC);
			}
			newStu.setCourses(newCourses);
			newStudents.add(newStu);
		}
		return newStudents;
	}

	public void addStudent(Student student) {		
		studentRepository.save(student);
	}
	
	public void updateStudentWithCourse(int id, Student student) {
		Student newStudent = studentRepository.findById(id);
		List<Course> courses = new ArrayList<>(student.getCourses());
		List<Course> newCourses = new ArrayList<>();
		for (Course course: courses) {
			Course newCourse = courseRepository.findById(course.getId()); 
			newCourses.add(newCourse);
		}
		newStudent.setUsername(student.getUsername());
		newStudent.setPass(student.getPass());
		newStudent.setCourses(newCourses);
		studentRepository.save(newStudent);
	}
	
	public void deleteStudent(int id) {
		Student student = studentRepository.findById(id);
		List<Course> existingCourses = new ArrayList<>(student.getCourses());
		for (Course course : existingCourses) {
			student.removeCourses(course);
		}
		studentDetailRepository.delete(student.getStudentDetail());
	}

}
