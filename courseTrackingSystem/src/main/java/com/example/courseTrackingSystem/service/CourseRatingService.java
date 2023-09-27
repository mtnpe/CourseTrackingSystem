package com.example.courseTrackingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseTrackingSystem.models.CourseRatings;
import com.example.courseTrackingSystem.repository.CourseRatingRepository;

@Service
public class CourseRatingService {
	@Autowired
	private CourseRatingRepository courseRatingRepository;
	
	public void updateRating(int id, CourseRatings courseRating) {
		CourseRatings newCR = courseRatingRepository.findById(id);
		newCR.setRating(courseRating.getRating());
		newCR.setTimeRating(courseRating.getTimeRating());
		courseRatingRepository.save(newCR);
	}

}
