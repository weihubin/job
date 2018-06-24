package com.finrun.trading.exception;

import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller层全局异常处理类
 * @author user
 *
 */
@ControllerAdvice
public class ExceptionHandle {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto<Object> handleException(Exception e){
        if(e instanceof FrontException){
        	FrontException MyException = (FrontException) e;
            return ResultUtil.error(MyException.getCode(),MyException.getMessage());
        }

        logger.error("【系统异常】{}",e);
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }
    
    public static void throwException(ExceptionEnum exceptionEnum){
    	throw new FrontException(exceptionEnum);
    }
}
