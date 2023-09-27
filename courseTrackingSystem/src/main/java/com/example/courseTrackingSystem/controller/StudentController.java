//edited
package com.example.courseTrackingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.courseTrackingSystem.models.CourseRatings;
import com.example.courseTrackingSystem.models.Enrollments;
import com.example.courseTrackingSystem.models.Instructor;
import com.example.courseTrackingSystem.models.Student;
import com.example.courseTrackingSystem.models.StudentDetail;
import com.example.courseTrackingSystem.modelsDto.CourseDto;
import com.example.courseTrackingSystem.modelsDto.CourseRatingToCreate;
import com.example.courseTrackingSystem.modelsDto.CourseWithRatingsDto;
import com.example.courseTrackingSystem.modelsDto.EnrollmentDto;
import com.example.courseTrackingSystem.modelsDto.InstructorDto;
import com.example.courseTrackingSystem.modelsDto.StudentDetailDto;
import com.example.courseTrackingSystem.modelsDto.StudentWithCoursesDto;
import com.example.courseTrackingSystem.service.CourseRatingService;
import com.example.courseTrackingSystem.service.CourseRatingToCreateService;
import com.example.courseTrackingSystem.service.CourseService;
import com.example.courseTrackingSystem.service.EnrollmentService;
import com.example.courseTrackingSystem.service.InstructorService;
import com.example.courseTrackingSystem.service.StudentDetailService;
import com.example.courseTrackingSystem.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentDetailService studentDetailService;
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRatingToCreateService courseRatingToCreateService;
	@Autowired
	private EnrollmentService enrollmentService;
	@Autowired
	private CourseRatingService courseRatingService;
	
	@GetMapping(path = "/list-student")
	@ResponseStatus(code = HttpStatus.OK)
	public List<StudentWithCoursesDto> getStudent(){
		return studentService.getStudent();
	}
	
	@GetMapping(path = "/list-student-detail")
	@ResponseStatus(code = HttpStatus.OK)
	public List<StudentDetailDto> getStudentDetail(){
		return studentDetailService.getStudentDetail();
	}
	
	@GetMapping(path = "/list-instructor")
	@ResponseStatus(code = HttpStatus.OK)
	public List<InstructorDto> getInstructor(){
		return instructorService.getInstructor();
	}
	
	@GetMapping(path = "/list-course-with-ratings")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CourseWithRatingsDto> getCourse(){
		return courseService.getCourse();
	} 
	
//	@PostMapping(path = "/add-student")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public void addStudent(@RequestBody Student student) {
//		studentService.addStudent(student);
//	}
	
	@PostMapping(path = "/add-student-detail")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addStudentDetail(@RequestBody StudentDetail studentDetail) {
		studentDetailService.addStudentDetail(studentDetail);
	}
	
	@PostMapping(path = "/add-instructor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addInstructor(@RequestBody Instructor instructor) {
		instructorService.addInstructor(instructor);
	}
	
	@PostMapping(path = "/add-course-ratings")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addRating(@RequestBody CourseRatingToCreate courseRatingToCreate) {
		courseRatingToCreateService.addRating(courseRatingToCreate);
	}
	
	@PostMapping(path = "/add-course")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCourse(@RequestBody CourseDto courseDto) {
		courseService.addCourse(courseDto);
	}
	
	@PostMapping(path = "/add-enrollment")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
		enrollmentService.addEnrollment(enrollmentDto);
	}
	
	@PutMapping(path = "/update-student-detail/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateStudentDetail(@PathVariable int id, @RequestBody StudentDetail studentdetail) {
		studentDetailService.updateStudentDetail(id, studentdetail);
	}
	
	@PutMapping(path = "/update-instructor/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateInstructor(@PathVariable int id,@RequestBody Instructor instructor) {
		instructorService.updateInstructor(id, instructor);
	}
	
	@PutMapping(path = "/update-course-rating/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateRating(@PathVariable int id,@RequestBody CourseRatings courseRating) {
		courseRatingService.updateRating(id, courseRating);
	}
	
	@PutMapping(path = "/update-course/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateCourse(@PathVariable int id,@RequestBody CourseDto courseDto) {
		courseService.updateCourse(id, courseDto);
	}
	
	@PutMapping(path = "/update-student-with-course/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateStudentWithCourse(@PathVariable int id,@RequestBody Student student) {
		studentService.updateStudentWithCourse(id, student);
	}
	
	@PutMapping(path = "/update-enrollment/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateEnrollment(@PathVariable int id,@RequestBody Enrollments enrollment) {
		enrollmentService.updateEnrollment(id, enrollment);
	}
	@DeleteMapping(path = "/delete-rating/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteRating(@PathVariable int id) {
		courseRatingToCreateService.deleteRating(id);
	}
	
	@DeleteMapping(path = "/delete-student/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
	
	@DeleteMapping(path = "/delete-instructor/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteInstructor(@PathVariable int id) {
		instructorService.deleteInstructor(id);
	}
	
	@DeleteMapping(path = "/delete-course/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}

	
}
