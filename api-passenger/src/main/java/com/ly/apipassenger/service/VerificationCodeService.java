package com.ly.apipassenger.service;

import com.ly.internalcommon.dto.ResponseResult;

public interface VerificationCodeService {

    /**
     * 调用验证码服务，获取验证码
     * @param passengerPhone
     * @return
     */
    ResponseResult generateCode(String passengerPhone);
}
