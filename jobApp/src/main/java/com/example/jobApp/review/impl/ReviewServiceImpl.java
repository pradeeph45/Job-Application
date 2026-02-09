package com.example.jobApp.review.impl;

import com.example.jobApp.review.Review;
import com.example.jobApp.review.ReviewRepository;
import com.example.jobApp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllreviews(Long id) {
        return reviewRepository.findByCompanyId(id);
    }
}
