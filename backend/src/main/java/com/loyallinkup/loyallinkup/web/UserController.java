//package com.loyallinkup.loyallinkup.web;
//
//import com.loyallinkup.loyallinkup.model.dto.AdminDto;
//import com.loyallinkup.loyallinkup.model.dto.BusinessRegisterDto;
//import com.loyallinkup.loyallinkup.model.dto.ClientRegisterDto;
//import com.loyallinkup.loyallinkup.service.UserService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @PostMapping("/registerClient")
//    public void registerClient(@RequestBody ClientRegisterDto clientRegisterDto){
//        this.userService.register(null, clientRegisterDto,null);
//    }
//
//    @PostMapping("/registerBusiness")
//    public void registerBusiness(@RequestBody BusinessRegisterDto businessRegisterDto){
//        this.userService.register(businessRegisterDto, null,null);
//    }
//
//
//    @PostMapping("/registerAdmin")
//    public void registerAdmin(@RequestBody AdminDto adminDto){
//        this.userService.register(null, null  ,adminDto);
//    }
//}
