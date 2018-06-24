package com.finrun.trading.controller;

import com.finrun.trading.common.URL;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.exception.FrontException;
import com.finrun.trading.service.ReqOrderActionService;
import com.finrun.trading.service.ReqOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weihubin on 2018-03-30.
 */
@RestController
@CrossOrigin
public class ReqOrderController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(ReqOrderController.class);

    @Autowired
    private ReqOrderService reqOrderService;
    @Autowired
    private ReqOrderActionService reqOrderActionService;

    @RequestMapping(value = URL.REQ_ORDER_INSERT, method = RequestMethod.POST)
    public ResultDto<?> reqOrderInsert(@RequestBody String msg) {
        try {
            return reqOrderService.reqOrderInsert(msg);
        } catch (FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }

    @RequestMapping(value = URL.REQ_ORDER_ACTION, method = RequestMethod.POST)
    public ResultDto<?> reqOrderAction(@RequestBody String msg) {
        try {
            return reqOrderActionService.reqOrderAction(msg);
        } catch (FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }
}
