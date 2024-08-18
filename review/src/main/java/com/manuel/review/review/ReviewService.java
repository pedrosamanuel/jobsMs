package com.manuel.review.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public Boolean addReview(Long companyId, Review review) {
        if(companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public Boolean deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    public Boolean updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null){
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            reviewRepository.save(review);
            return true;
                }
        return false;
    }
}
