package com.ly.apipassenger.service;

import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.response.TokenResponse;

public interface VerificationCodeService {

    /**
     * 调用验证码服务，获取验证码
     * @param passengerPhone
     */
    void generateCode(String passengerPhone);


    TokenResponse checkCode(String passengerPhone, String verificationCode);
}
