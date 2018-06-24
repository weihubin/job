package com.finrun.trading.controller;

import com.finrun.trading.common.URL;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.exception.FrontException;
import com.finrun.trading.service.QryInvestorPosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weihubin on 2018-04-04.
 */
@RestController
@CrossOrigin
public class QryInvestorPosController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(QryInvestorPosController.class);
    @Autowired
    private QryInvestorPosService qryInvestorPosService;

    @RequestMapping(value = URL.REQ_QRY_INVESTOR_POS, method= RequestMethod.POST)
    public ResultDto<?> qryInvestorPos(@RequestBody String msg) {
        try {
            return qryInvestorPosService.qryInvestorPos(msg);
        } catch(FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch(Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }

}

