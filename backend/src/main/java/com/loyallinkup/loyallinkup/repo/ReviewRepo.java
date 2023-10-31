package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findAllByBusiness_Id(Long business_id);


    List<Review> findAllByClient_Id
            (Long client_id);

    List<Review> findAllByEvent_Id(Long event_id);
//    //dali ke raboti so vakvo ID ili _id ili moze kombinacija od site so or
}
