package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.models.Enrollments;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Integer>{
	Enrollments findById(int id);
}
