package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	Course findById(int id);
	boolean findAllById(int id);
}
