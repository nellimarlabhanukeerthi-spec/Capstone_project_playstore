package com.playstore.reviewms.service.impl;

import com.playstore.reviewms.entity.Review;
import com.playstore.reviewms.repository.ReviewRepository;
import com.playstore.reviewms.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByAppId(Long appId) {
        return reviewRepository.findByAppId(appId);
    }

    @Override
    public double getAverageRating(Long appId) {
        List<Review> reviews = reviewRepository.findByAppId(appId);
        if (reviews.isEmpty()) return 0.0;
        return reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
    }
}
