package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.modelsDto.CourseDto;

@Repository
public interface CourseDtoRepository extends JpaRepository<CourseDto, Integer> {

}
