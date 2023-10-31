package com.loyallinkup.loyallinkup.web;

import com.loyallinkup.loyallinkup.model.Address;
import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.dto.AddressDto;
import com.loyallinkup.loyallinkup.model.dto.BusinessDto;
import com.loyallinkup.loyallinkup.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public List<Address> getAllAdresses() {
        return addressService.listAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        Address address = addressService.findById(id);
        return address;
    }

    @PostMapping("/add")
    public Address createAddress(@RequestBody AddressDto addressDto) {
        Address createdAddress = addressService.create(addressDto);
        return createdAddress;
    }

    @PutMapping("/edit/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        Address updatedAddress = addressService.edit(id, addressDto);
        return updatedAddress;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAddress(@PathVariable Long id) {
        boolean deleted = addressService.delete(id);
        return deleted;
    }
}
