package com.ly.apipassenger.service.impl;

import com.ly.apipassenger.remote.ServicePassengerUserClient;
import com.ly.apipassenger.remote.ServiceVerificationcodeClient;
import com.ly.apipassenger.service.VerificationCodeService;
import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.request.VerificationCodeDTO;
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
    private ServicePassengerUserClient servicePassengerUserClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void generateCode(String passengerPhone) {
        ResponseResult<NumberCodeResponse> numberCodeResponseResponseResult = serviceVerificationcodeClient.numberCode(6);
        int numberCode = numberCodeResponseResponseResult.getData().getNumberCode();
        stringRedisTemplate.opsForValue().set(generatorKeyByPhone(passengerPhone), String.valueOf(numberCode), 2, TimeUnit.MINUTES);
        // 调用第三方平台短信发送服务
    }

    @Override
    public TokenResponse checkCode(String passengerPhone, String verificationCode) {
        String key = generatorKeyByPhone(passengerPhone);
        String val = stringRedisTemplate.opsForValue().get(key);

        if (!verificationCode.trim().equals(val)) {
            return null;
        }

        servicePassengerUserClient.loginOrRegister(new VerificationCodeDTO(passengerPhone, verificationCode));

        return new TokenResponse("token value");
    }


    private String generatorKeyByPhone(String passengerPhone) {
        return verificationCodePrefix + passengerPhone;
    }
}
