package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-05-14.
 */
public interface QryInstrumentService {
    /**
     * 查询合约信息
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto qryInstrument(String msg) throws Exception;

    /**
     * 同步交易所所有合约信息
     * @return
     * @throws Exception
     */
    ResultDto synInstruments() throws Exception;
}
