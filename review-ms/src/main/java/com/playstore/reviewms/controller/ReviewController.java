package com.playstore.reviewms.controller;

import com.playstore.reviewms.entity.Review;
import com.playstore.reviewms.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/app/{appId}")
    public List<Review> getReviewsByApp(@PathVariable Long appId) {
        return reviewService.getReviewsByAppId(appId);
    }

    @GetMapping("/app/{appId}/average")
    public double getAverageRating(@PathVariable Long appId) {
        return reviewService.getAverageRating(appId);
    }
}
