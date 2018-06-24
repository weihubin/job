package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-05-22.
 */
public interface ReqQryOrderService {
    /**
     * 报单查询
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto reqQryOrder(String msg) throws Exception;
}
