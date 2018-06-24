package com.finrun.trading.common.enums;

/**
 * Created by weihubin on 2018/3/5.
 */
public enum ExceptionEnum {
    ERROR("0",""),
    UNKNOW_ERROR("-1","未知错误"),
    UNIMPLEMENT_ERROR("-2","接口未实现"),
    CONTRACT_ISEMPTY_ERROR("-3","合约不能为空!"),
    CONTRACT_ISNOTEXIST_ERROR("-4","合约不存在!"),
    ;
    private String code;
    private String msg;
    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ExceptionEnum fromCode(String code) {
        for (ExceptionEnum eEnum : ExceptionEnum.values()) {
            if (eEnum.getCode().equals(code)) {
                return eEnum;
            }
        }
        return null;
    }
}
