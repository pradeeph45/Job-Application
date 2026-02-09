package com.example.jobApp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllreviews(Long id);

    boolean addReview(Long id,Review review);

    Review getReviewById(Long companyId,Long reviewId);

    boolean updateReview(Long companyId,Long reviewId,Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
