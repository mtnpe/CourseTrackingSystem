package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findById(int id);
}
