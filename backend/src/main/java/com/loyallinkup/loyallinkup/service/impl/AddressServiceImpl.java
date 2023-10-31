package com.loyallinkup.loyallinkup.service.impl;

import com.loyallinkup.loyallinkup.model.Address;
import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.dto.AddressDto;
import com.loyallinkup.loyallinkup.model.exceptions.InvalidBusinessIdException;
import com.loyallinkup.loyallinkup.repo.AddressRepo;
import com.loyallinkup.loyallinkup.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address create(AddressDto addressDto) {
        Address address = new Address(addressDto.getCity_name(),addressDto.getStreet_name(),addressDto.getStreet_number());
        return addressRepo.save(address);
    }

    @Override
    public Address edit(Long id, AddressDto addressDto) {
        Address address = this.addressRepo.findById(id).orElseThrow(InvalidBusinessIdException::new);
        address.setCity_name(addressDto.getCity_name());
        address.setStreet_name(addressDto.getStreet_name());
        address.setStreet_number(addressDto.getStreet_number());
        this.addressRepo.save(address);
        return address;
    }

    @Override
    public Boolean delete(Long id) {
        if(this.addressRepo.findById(id).isPresent()){
            this.addressRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public List<Address> listAll() {
        return this.addressRepo.findAll();
    }

    @Override
    public Address findById(Long id) {
        return this.addressRepo.findById(id).get();
    }
}
