package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-05-15.
 */
public interface CtpQryInstrumentService {
    /**
     * 所有合约信息
     * @return
     */
    void ctpQryInstruments() throws Exception;
}
