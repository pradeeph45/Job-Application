package com.example.jobApp.review.impl;

import com.example.jobApp.company.Company;
import com.example.jobApp.company.CompanyService;
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

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getAllreviews(Long id) {
        return reviewRepository.findByCompanyId(id);
    }

    @Override
    public boolean addReview(Long id, Review review) {
        Company company = companyService.getCompanyById(id);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) !=null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = companyService.getCompanyById(companyId);
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
