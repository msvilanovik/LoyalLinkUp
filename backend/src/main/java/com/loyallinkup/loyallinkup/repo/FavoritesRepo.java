package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepo extends JpaRepository<Favorites, Long> {

    List<Favorites> findAllByBusinessId(Long business_id);
    List<Favorites> findAllByClientId(Long client_id);
}
