package com.example.courseTrackingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courseTrackingSystem.modelsDto.EnrollmentDto;

@Repository
public interface EnrollmentDtoRepository extends JpaRepository<EnrollmentDto, Integer>{

}
