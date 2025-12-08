package com.playstore.reviewms.service;

import com.playstore.reviewms.entity.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Review review);

    List<Review> getReviewsByAppId(Long appId);

    double getAverageRating(Long appId);
}
