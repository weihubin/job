package com.finrun.trading.common.utils;


import com.finrun.trading.common.CONST;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;

public class ResultUtil {
	/**
	 * 返回成功，传入返回体具体出參
	 * @param object
	 * @return
	 */
    public static <T> ResultDto<T> success(T object){
        ResultDto<T> result = new ResultDto<>();
        result.setStatus(CONST.RETURN_OK);
        result.setErrMsg("执行成功！");
        result.setBody(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static <T> ResultDto<T> success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static <T> ResultDto<T> error(String code,String msg){
    	ResultDto<T> result = new ResultDto<>();
    	result.setStatus(CONST.RETURN_NG);
        result.setErrCode(code);
        result.setErrMsg(msg);
        result.setBody(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static <T> ResultDto<T> error(ExceptionEnum exceptionEnum){
        ResultDto<T> result = new ResultDto<>();
        result.setStatus(CONST.RETURN_NG);
        result.setErrCode(exceptionEnum.getCode());
        result.setErrMsg(exceptionEnum.getMsg());
        result.setBody(null);
        return result;
    }
}
