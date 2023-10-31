package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.Review;
import com.loyallinkup.loyallinkup.model.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<Review> listAll();

    Review findById(Long id);

    Boolean deleteById(Long id);

    Review edit(Long id, ReviewDto reviewDto);

    Review create(ReviewDto reviewDto);
    //dodadeni
    List<Review> listByClientId(Long client_id);
//
    List<Review> listByBusinessId(Long business_id);
//
    List<Review> listByEventId(Long event_id);
}
