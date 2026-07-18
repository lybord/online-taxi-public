package com.ly.servicepassengeruser.controller;

import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.request.VerificationCodeDTO;
import com.ly.servicepassengeruser.domain.PassengerUser;
import com.ly.servicepassengeruser.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private PassengerUserService passengerUserService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String verificationCode = verificationCodeDTO.getVerificationCode();
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        PassengerUser passengerUser = new PassengerUser();
        passengerUser.setPassengerName(passengerPhone);
        passengerUser.setPassengerPhone(passengerPhone);
        passengerUser.setPassengerGender(0);
        passengerUser.setState(0);
        passengerUserService.save(passengerUser);
        return ResponseResult.success();
    }
}
