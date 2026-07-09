package com.ly.internalcommon.constant;

public enum CommonStatusEnum {

    /** 验证码错误提示：1000 - 1099 */
    VERIFICATION_CODE_ERROR(1099, "验证码不正确"),

    SUCCESS(1, "success"),
    FAILED(0, "failed");

    private int code;
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
