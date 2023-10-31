package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.dto.BusinessDto;

import java.util.List;

public interface BusinessService {

    Business create(BusinessDto businessDto);

    Business edit(Long id, BusinessDto businessDto);

    Boolean delete(Long id);

    List<Business> listAll();

    Business findById(Long id);

    Business findByName(String name);

    List<Business> findByCity(String city_name);

    List<Business> searchByName(String name);

    //TODO:Event addEvent(EventDto eventDto); + drugite
}
