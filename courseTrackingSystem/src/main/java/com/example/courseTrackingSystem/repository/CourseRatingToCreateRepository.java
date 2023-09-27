package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.modelsDto.CourseRatingToCreate;

@Repository
public interface CourseRatingToCreateRepository extends JpaRepository<CourseRatingToCreate, Integer> {
	CourseRatingToCreate findById(int id);
}
