package com.example.courseTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.StudentDetail;
import com.example.courseTrackingSystem.modelsDto.StudentDetailDto;
import com.example.courseTrackingSystem.repository.StudentDetailRepository;

@Service
public class StudentDetailService {
	@Autowired
	private StudentDetailRepository studentDetailRepository;
	
	public List<StudentDetailDto> getStudentDetail(){
		List<StudentDetail> studentDetails =  studentDetailRepository.findAll();
		List<StudentDetailDto> studentDetailDto = new  ArrayList<>();
		for (StudentDetail stu: studentDetails) {
			StudentDetailDto stuDto = new StudentDetailDto();
			stuDto.setId(stu.getId());
			stuDto.setUsername(stu.getStudent().getUsername());
			stuDto.setAddress(stu.getAddress());
			stuDto.setBirthday(stu.getBirthday());
			stuDto.setEmail(stu.getEmail());
			stuDto.setFullname(stu.getFullname());
			stuDto.setPhone(stu.getPhone());
			studentDetailDto.add(stuDto);
		}
		return studentDetailDto;
	}

	public void addStudentDetail(StudentDetail studentDetail) {
		studentDetailRepository.save(studentDetail);
	}
	
	public void updateStudentDetail(int id, StudentDetail studentDetail) {
		studentDetail.setId(id);
		studentDetailRepository.save(studentDetail);
	}

}
