package com.ly.apipassenger.controller;

import com.ly.apipassenger.request.VerificationCodeDTO;
import com.ly.apipassenger.service.VerificationCodeService;
import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.response.NumberCodeResponse;
import com.ly.internalcommon.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return verificationCodeService.generateCode(passengerPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult<TokenResponse> checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();
        TokenResponse tokenResponse = verificationCodeService.checkCode(passengerPhone, verificationCode);
        return ResponseResult.success(tokenResponse);
    }
}
