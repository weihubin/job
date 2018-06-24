package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-04-04.
 */
public interface QryTradingAccService {
    /**
     * 查询投资人资金账户信息
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto qryTradingAcc(String msg) throws Exception;
}
