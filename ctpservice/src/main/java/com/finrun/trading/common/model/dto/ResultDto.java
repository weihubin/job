package com.finrun.trading.common.model.dto;




import com.finrun.trading.common.CONST;

import java.io.Serializable;

/**
 * @author xww
 * Date: 2017-8-15.
 */
public class ResultDto<T> implements Serializable {

	private static final long serialVersionUID = 7098398557300885180L;

	private String status;
	private String errCode;
	private String errMsg;
	private T body;

	public ResultDto() {
		
	}

	public ResultDto(String status, String errCode, String errMsg, T body) {
		this.status = status;
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
	public boolean isSuccess() {
		return CONST.RETURN_OK.equals(this.status);
	}
	
}
