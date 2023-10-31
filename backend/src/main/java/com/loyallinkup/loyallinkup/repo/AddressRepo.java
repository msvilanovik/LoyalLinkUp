package com.loyallinkup.loyallinkup.repo;

import com.loyallinkup.loyallinkup.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
