package com.loyallinkup.loyallinkup.web;


import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.Enum.TypeOfBusiness;
import com.loyallinkup.loyallinkup.model.dto.BusinessDto;
import org.springframework.web.bind.annotation.*;
import com.loyallinkup.loyallinkup.service.BusinessService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

        private final BusinessService businessService;

        public BusinessController(BusinessService businessService) {
            this.businessService = businessService;
        }

        @GetMapping
        public List<Business> getAllBusinesses() {
            return businessService.listAll();
        }

        @GetMapping("name/{name}")
        public Business getBusinessByName(@PathVariable String name){
            return businessService.findByName(name);
        }

        @GetMapping("/{id}")
        public Business getBusinessById(@PathVariable Long id) {
            Business business = businessService.findById(id);
            return business;
        }

        @PostMapping("/add")
        public Business createBusiness(@RequestBody BusinessDto businessDto) {
            Business createdBusiness = businessService.create(businessDto);
            return createdBusiness;
        }

        @PutMapping("/edit/{id}")
        public Business updateBusiness(@PathVariable Long id, @RequestBody BusinessDto businessDto) {
            Business updatedBusiness = businessService.edit(id, businessDto);
            return updatedBusiness;
        }

        @DeleteMapping("/delete/{id}")
        public boolean deleteBusiness(@PathVariable Long id) {
            boolean deleted = businessService.delete(id);
            return deleted;
        }

        @GetMapping("/city/{name}")
        public List<Business> getBusinessesByCity(@PathVariable String name) {
            return businessService.findByCity(name);
        }

        @GetMapping("/search")
        public List<Business> searchBusinessesByName(@RequestParam String name) {
            return this.businessService.searchByName(name);
        }

        @GetMapping("/types")
        public List<TypeOfBusiness> listTypeOfBusinesses() {
            return Arrays.stream(TypeOfBusiness.values()).toList();
        }
}

