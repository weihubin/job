package com.finrun.trading.exception;


import com.finrun.trading.common.enums.ExceptionEnum;

public class FrontException extends RuntimeException {

	private static final long serialVersionUID = -6713723432193256214L;
	
	private String code;
	
	public FrontException(String msg) {  
        super(msg);  
    }
	
	/**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public FrontException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public FrontException(String message, String code) {
        super(message);
        this.code = code;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
