package com.ly.servicepassengeruser.controller;

import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.request.VerificationCodeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        System.out.println(verificationCodeDTO);
        return ResponseResult.success();
    }
}
