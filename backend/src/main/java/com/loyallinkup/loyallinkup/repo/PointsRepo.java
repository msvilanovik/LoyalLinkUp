package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointsRepo extends JpaRepository<Points, Long> {
}
