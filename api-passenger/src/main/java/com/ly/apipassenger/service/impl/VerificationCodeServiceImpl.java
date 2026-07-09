package com.ly.apipassenger.service.impl;

import com.ly.apipassenger.remote.ServiceVerificationcodeClient;
import com.ly.apipassenger.service.VerificationCodeService;
import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.response.NumberCodeResponse;
import com.ly.internalcommon.response.TokenResponse;
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
        stringRedisTemplate.opsForValue().set(generatorKeyByPhone(passengerPhone), String.valueOf(numberCode), 2, TimeUnit.MINUTES);
        // 调用第三方平台短信发送服务
        return ResponseResult.success();
    }

    @Override
    public TokenResponse checkCode(String passengerPhone, String verificationCode) {
        String key = generatorKeyByPhone(passengerPhone);
        String val = stringRedisTemplate.opsForValue().get(key);
        if (verificationCode.equals(val)) {
            return new TokenResponse("token value");
        }
        return null;
    }


    private String generatorKeyByPhone(String passengerPhone) {
        return verificationCodePrefix + passengerPhone;
    }
}
