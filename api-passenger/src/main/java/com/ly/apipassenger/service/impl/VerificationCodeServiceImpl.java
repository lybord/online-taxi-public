package com.ly.apipassenger.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.apipassenger.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String generateCode(String passengerPhone) {
        String code = "111111";
        try {
            return objectMapper.writeValueAsString(Map.of(
                    "code", 1,
                    "message", "success",
                    "data", code
            ));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
