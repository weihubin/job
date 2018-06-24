package com.finrun.trading.controller;

import com.finrun.trading.common.URL;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.exception.FrontException;
import com.finrun.trading.service.ReqQryOrderService;
import com.finrun.trading.service.ReqQryTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weihubin on 2018-04-04.
 */
@RestController
@CrossOrigin
public class ReqQryTradeController  extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ReqQryTradeController.class);

    @Autowired
    private ReqQryTradeService reqQryTradeService;

    @Autowired
    private ReqQryOrderService reqQryOrderService;


    @RequestMapping(value = URL.REQ_QRY_ORDER, method = RequestMethod.POST)
    public ResultDto<?> reqQryOrder(@RequestBody String msg) {
        try {
            return reqQryOrderService.reqQryOrder(msg);
        } catch (FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }

    @RequestMapping(value = URL.REQ_QRY_TRADE, method = RequestMethod.POST)
    public ResultDto<?> reqQryTrade(@RequestBody String msg) {
        try {
            return reqQryTradeService.reqQryTrade(msg);
        } catch (FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }
}
