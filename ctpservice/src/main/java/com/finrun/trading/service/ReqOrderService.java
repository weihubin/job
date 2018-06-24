package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-03-29.
 */
public interface ReqOrderService {
    /**
     * 报单录入
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto reqOrderInsert(String msg) throws Exception;
}
