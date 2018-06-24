package com.finrun.trading.controller;

import com.finrun.trading.common.URL;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.exception.FrontException;
import com.finrun.trading.service.QryInstrumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weihubin on 2018-05-14.
 */
@RestController
@CrossOrigin
public class ReqQryInstrumentController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ReqQryInstrumentController.class);

    @Autowired
    private QryInstrumentService qryInstrumentService;

    @RequestMapping(value = URL.REQ_QRY_INSTRUMENT, method = RequestMethod.POST)
    public ResultDto<?> reqQryTrade(@RequestBody String msg) {
        try {
            return qryInstrumentService.qryInstrument(msg);
        } catch (FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }


    @RequestMapping(value = URL.SYN_INSTRUMENTS, method = RequestMethod.POST)
    public ResultDto<?> synInstruments() {
        try {
            return qryInstrumentService.synInstruments();
        } catch (FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }

}
