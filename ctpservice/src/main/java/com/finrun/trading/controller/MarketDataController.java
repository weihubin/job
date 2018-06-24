package com.finrun.trading.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.finrun.trading.common.URL;
import com.finrun.trading.common.enums.ExceptionEnum;
import com.finrun.trading.common.model.dto.ResultDto;
import com.finrun.trading.common.utils.ResultUtil;
import com.finrun.trading.exception.FrontException;
import com.finrun.trading.service.MarketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weihubin on 2018-03-28.
 */
@RestController
@CrossOrigin
public class MarketDataController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(MarketDataController.class);

    @Autowired
    private MarketDataService marketDataService;

    @RequestMapping(value = URL.SUBSCRIBE_MARKET_DATA, method= RequestMethod.POST)
    public ResultDto<?> subscribeMarketData(@RequestBody String msg) {
        try {
            JSONObject jsonObject = JSON.parseObject(msg);
            JSONArray array = jsonObject.getJSONArray("instrumentIdList");
            if(array == null || array.size() == 0){
                return ResultUtil.error(ExceptionEnum.CONTRACT_ISEMPTY_ERROR);
            }
            return marketDataService.subscribeMarketData(array.toArray(new String[0]));
        } catch(FrontException fe) {
            logger.info(fe.getMessage(), fe);
            return ResultUtil.error(fe.getMessage(), fe.getCode());
        } catch(Exception e) {
            logger.info(e.getMessage(), e);
            return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
        }
    }

}
