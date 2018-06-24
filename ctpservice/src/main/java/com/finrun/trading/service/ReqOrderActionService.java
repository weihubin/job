package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-05-15.
 */
public interface ReqOrderActionService {
    /**
     * 报单操作请求
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto reqOrderAction(String msg) throws Exception;
}
