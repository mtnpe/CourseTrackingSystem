package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.models.CourseRatings;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRatings, Integer> {
	CourseRatings findById(int id);
}
