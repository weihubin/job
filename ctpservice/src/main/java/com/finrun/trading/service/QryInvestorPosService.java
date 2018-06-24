package com.finrun.trading.service;

import com.finrun.trading.common.model.dto.ResultDto;

/**
 * Created by weihubin on 2018-04-04.
 */
public interface QryInvestorPosService {
    /**
     * 查询投资人持仓
     * @param msg
     * @return
     * @throws Exception
     */
    ResultDto qryInvestorPos(String msg) throws Exception;
}
