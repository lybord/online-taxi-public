package com.ly.apipassenger.remote;

import com.ly.internalcommon.dto.ResponseResult;
import com.ly.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {

    @GetMapping("/numberCode/{size}")
    ResponseResult<NumberCodeResponse> numberCode(@PathVariable Integer size);

}
