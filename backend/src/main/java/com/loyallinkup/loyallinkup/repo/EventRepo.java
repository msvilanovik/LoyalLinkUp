package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.Enum.TypeOfEvent;
import com.loyallinkup.loyallinkup.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {


    List<Event> findAllByBusiness_Id(Long business_id);
    @Query("SELECT e FROM Event e WHERE e.type_of_event = :type_of_event")
    List<Event> findAllByType(@Param("type_of_event") TypeOfEvent type_of_event);
}
