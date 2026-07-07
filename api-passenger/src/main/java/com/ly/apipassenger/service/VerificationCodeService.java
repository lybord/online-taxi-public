package com.ly.apipassenger.service;

public interface VerificationCodeService {

    /**
     * 调用验证码服务，获取验证码
     * @param passengerPhone
     * @return
     */
    String generateCode(String passengerPhone);
}
