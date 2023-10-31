package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.Address;
import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.dto.AddressDto;
import com.loyallinkup.loyallinkup.model.dto.BusinessDto;

import java.util.List;

public interface AddressService {

    Address create(AddressDto addressDto);

    Address edit(Long id, AddressDto addressDto);

    Boolean delete(Long id);

    List<Address> listAll();

    Address findById(Long id);
}
