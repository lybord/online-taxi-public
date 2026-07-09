package com.ly.serviceverificationcode.controller;

import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.response.NumberCodeResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult<NumberCodeResponse> numberCode(@PathVariable Integer size) {
        int numberCode = Integer.parseInt(RandomStringUtils.random(1, '1', '9', false, true) + RandomStringUtils.randomNumeric(size - 1));
        return ResponseResult.success(new NumberCodeResponse(numberCode));
    }
}
