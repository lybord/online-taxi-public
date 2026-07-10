package com.ly.internalcommon.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VerificationCodeDTO {

    private String passengerPhone;

    private String verificationCode;

}
