package com.finrun.trading.common.utils;

import com.finrun.trading.common.model.ctp.CThostFtdcRspUserLoginField;

import java.math.BigDecimal;

/**
 * Created by weihubin on 2018-05-29.
 */
public class CtpUtil {
    public static BigDecimal doubleToBigDecimal(double d){
        Double d1 = new Double(d);
        if(d1 == null || d1 == 1.7976931348623157E308){
            return BigDecimal.ZERO;
        }
        return new BigDecimal(d1.toString());
    }

    /**
     * 获取相关委托编号
     * @param userLoginField
     * @return
     */
    public static int getMaxOrderRef(CThostFtdcRspUserLoginField userLoginField){
        int maxOrderRef = 0;
        synchronized (CtpUtil.class){
            maxOrderRef = Integer.parseInt(userLoginField.getMaxOrderRef()) + 1;
            userLoginField.setMaxOrderRef(String.valueOf(maxOrderRef));
        }
        return maxOrderRef;
    }

}
