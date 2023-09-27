package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.models.StudentDetail;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {
	StudentDetail findById(int id);
}
