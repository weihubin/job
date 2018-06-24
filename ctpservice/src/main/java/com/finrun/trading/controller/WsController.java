package com.finrun.trading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by weihubin on 2018-05-31.
 */
@Controller
public class WsController {

    @RequestMapping("/")
    public String index() {
        return "/index";
    }


    @RequestMapping("/ws")
    public String ws() {
        return "/ws";
    }
}



