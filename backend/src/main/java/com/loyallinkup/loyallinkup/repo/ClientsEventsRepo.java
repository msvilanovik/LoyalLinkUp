package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.ClientsEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsEventsRepo extends JpaRepository<ClientsEvents, Long> {
}
