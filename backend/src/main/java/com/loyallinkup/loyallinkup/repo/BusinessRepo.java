package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepo extends JpaRepository<Business, Long> {

    Business getBusinessByName(String name);

    @Query("SELECT b FROM Business b JOIN b.address a WHERE a.city_name = :city")
    List<Business> findBusinessByCity(@Param("city") String city);

    List<Business> findAllByNameContains(String name);

}
