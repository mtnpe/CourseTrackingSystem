package com.example.courseTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.Course;
import com.example.courseTrackingSystem.models.Instructor;
import com.example.courseTrackingSystem.modelsDto.CourseWithoutInstructorDto;
import com.example.courseTrackingSystem.modelsDto.InstructorDto;
import com.example.courseTrackingSystem.repository.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;
	
	public List<InstructorDto> getInstructor(){
		List<Instructor> instructors = instructorRepository.findAll();
		List<InstructorDto> newInstructors = new ArrayList<>();
		for (Instructor ins: instructors) {
			InstructorDto newIns = new InstructorDto() ;
			newIns.setId(ins.getId());
			newIns.setName(ins.getName());
			newIns.setEmail(ins.getEmail());
			newIns.setPhone(ins.getPhone());
			List<CourseWithoutInstructorDto> newCourse = new ArrayList<>();
			List<Course> course = ins.getCourse();
			for (Course c: course) {
				CourseWithoutInstructorDto newC = new CourseWithoutInstructorDto();
				newC.setId(c.getId());
				newC.setNameCourse(c.getNameCourse());
				newC.setDuration(c.getDuration());
				newC.setTimeStart(c.getTimeStart());
				newC.setFees(c.getFees());
				newCourse.add(newC);
			}
			newIns.setCourses(newCourse);
			newInstructors.add(newIns);
		}
		return newInstructors;
				
	}
	
	public void addInstructor(Instructor instructor) {
		instructorRepository.save(instructor);
	}
	
	public void updateInstructor(int id, Instructor instructor) {
		instructor.setId(id);
		instructorRepository.save(instructor);
	}
	
	public void deleteInstructor(int id) {
		Instructor instructor = instructorRepository.findById(id);
		instructorRepository.delete(instructor);
	}
}
