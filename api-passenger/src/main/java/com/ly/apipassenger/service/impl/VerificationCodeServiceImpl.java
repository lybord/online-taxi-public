package com.ly.apipassenger.service.impl;

import com.ly.apipassenger.remote.ServiceVerificationcodeClient;
import com.ly.apipassenger.service.VerificationCodeService;
import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.response.NumberCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private static final String verificationCodePrefix = "passenger:verification:code:";

    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseResult generateCode(String passengerPhone) {
        ResponseResult<NumberCodeResponse> numberCodeResponseResponseResult = serviceVerificationcodeClient.numberCode(6);
        int numberCode = numberCodeResponseResponseResult.getData().getNumberCode();
        stringRedisTemplate.opsForValue().set(verificationCodePrefix + passengerPhone, String.valueOf(numberCode), 2, TimeUnit.MINUTES);
        // 调用第三方平台短信发送服务
        return ResponseResult.success();
    }
}
