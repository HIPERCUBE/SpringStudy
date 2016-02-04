package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch03Dto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Copyright (c) 2/4/16 Joowon Ryoo
 * <p>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

@Controller
public class Ch03Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch03Controller.class);

    @RequestMapping("/ch03/content")
    public String content() {
        return "ch03/content";
    }

    @RequestMapping("/ch03/ppt")
    public String ppt() {
        return "ch03/ppt";
    }

    @RequestMapping("/ch03/method1")
    public String method1(String param1, int param2, double param3, boolean param4, @DateTimeFormat(pattern = "yyyy-MM-dd") Date param5) {
        logger.info("method1()");
        logger.info("param1: " + param1);
        logger.info("param2: " + param2);
        logger.info("param3: " + param3);
        logger.info("param4: " + param4);
        logger.info("param5: " + param5);
        return "ch03/content";
    }

    @RequestMapping("/ch03/method2")
    public String method2(@RequestParam("param1") String arg1, @RequestParam("param2") int arg2, @RequestParam("param3") double arg3, @RequestParam("param4") boolean arg4) {
        logger.info("method1()");
        logger.info("arg1: " + arg1);
        logger.info("arg2: " + arg2);
        logger.info("arg3: " + arg3);
        logger.info("arg4: " + arg4);
        return "ch03/content";
    }

    @RequestMapping("/ch03/method3")
    public String method3(@RequestParam(required = true) String param1, @RequestParam(required = true) String param2) {
        logger.info("method1()");
        logger.info("param1: " + param1);
        logger.info("param2: " + param2);
        return "ch03/content";
    }

    @RequestMapping("/ch03/method4")
    public String method4(
            @RequestParam(defaultValue = "문자열") String param1,
            @RequestParam(defaultValue = "0") int param2,
            @RequestParam(defaultValue = "0.0") double param3,
            @RequestParam(defaultValue = "false") double param4) {
        logger.info("method4()");
        logger.info("param1: " + param1);
        logger.info("param1: " + param2);
        logger.info("param1: " + param3);
        logger.info("param1: " + param4);
        return "ch03/content";
    }

    @RequestMapping("/ch03/method5")
    public String method5(Ch03Dto dto) {
        logger.info("method5()");
        logger.info("param1: " + dto.getParam1());
        logger.info("param2: " + dto.getParam2());
        logger.info("param3: " + dto.getParam3());
        logger.info("param4: " + dto.isParam4());
        logger.info("param5: " + dto.getParam5());
        return "ch03/content";
    }
}
