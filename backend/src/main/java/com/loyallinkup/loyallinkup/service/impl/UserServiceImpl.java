//package com.loyallinkup.loyallinkup.service.impl;
//
//import com.loyallinkup.loyallinkup.model.Address;
//import com.loyallinkup.loyallinkup.model.Business;
//import com.loyallinkup.loyallinkup.model.Client;
//import com.loyallinkup.loyallinkup.model.User;
//import com.loyallinkup.loyallinkup.model.dto.*;
//import com.loyallinkup.loyallinkup.repo.AddressRepo;
//import com.loyallinkup.loyallinkup.repo.BusinessRepo;
//import com.loyallinkup.loyallinkup.repo.ClientRepo;
//import com.loyallinkup.loyallinkup.repo.UserRepo;
//import com.loyallinkup.loyallinkup.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepo userRepo;
//    private final BusinessRepo businessRepo;
//
//    private final PasswordEncoder passwordEncoder;
//    private final AddressRepo addressRepo;
//    private final ClientRepo clientRepo;
//    public UserServiceImpl(UserRepo userRepo, BusinessRepo businessRepo, PasswordEncoder passwordEncoder, AddressRepo addressRepo, ClientRepo clientRepo) {
//        this.userRepo = userRepo;
//        this.businessRepo = businessRepo;
//        this.passwordEncoder = passwordEncoder;
//        this.addressRepo = addressRepo;
//        this.clientRepo = clientRepo;
//    }
//
//    @Override
//    public User findUserById(Long id) {
//        return this.userRepo.findById(id).orElse(null);
//    }
//    @Override
//    public Boolean existsByUsername(String username) {
//        return this.userRepo.existsUserByUsername(username);
//    }
//    @Override
//    public void register(BusinessRegisterDto businessDto , ClientRegisterDto clientDto, AdminDto adminDto) {
//        if (businessDto != null) {
//            Address address = new Address(businessDto.getAddressDto().getCity_name(),
//                    businessDto.getAddressDto().getStreet_name(),
//                    businessDto.getAddressDto().getStreet_number());
//            addressRepo.save(address);
//
//            Business business = this.businessRepo.save(new Business(
//                    businessDto.getName(),
//                    address,
//                    businessDto.getPhone_number(),
//                    businessDto.getType_of_business()
//            ));
//
//             this.userRepo.save(new User(
//                    businessDto.getUsername(),
//                    passwordEncoder.encode(businessDto.getPassword()),
//                    businessDto.getRole(),
//                    business
//            ));
//        } else if (clientDto != null) {
//            Client client = this.clientRepo.save(new Client(
//                    clientDto.getName(),
//                    clientDto.getSurname(),
//                    clientDto.getPhone_number()
//            ));
//             this.userRepo.save(new User(
//                    clientDto.getUsername(),
//                    passwordEncoder.encode(clientDto.getPassword()),
//                    clientDto.getRole(),
//                    client
//            ));
//        } else if (adminDto != null) {
//             this.userRepo.save(new User(
//                    adminDto.getUsername(),
//                    passwordEncoder.encode(adminDto.getPassword()),
//                    adminDto.getRole()
//            ));
//        }
//
//    }
//
//    public UserDetails loadUserByUsername(String username) {
//        return this.userRepo.findUserByUsername(username);
//    }
//
//}
