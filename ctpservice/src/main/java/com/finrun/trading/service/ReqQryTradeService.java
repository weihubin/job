package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-04-04.
 */
public interface ReqQryTradeService {
    /**
     * 查询成交
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto reqQryTrade(String msg) throws Exception;
}
