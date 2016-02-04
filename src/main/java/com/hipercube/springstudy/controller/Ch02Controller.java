package com.hipercube.springstudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class Ch02Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);

    @RequestMapping("/ch02/content")
    public String content() {
        return "ch02/content";
    }

    @RequestMapping("/ch02/ppt")
    public String ppt() {
        return "ch02/ppt";
    }

    @RequestMapping(value = "/ch02/getMethod", method = RequestMethod.GET)
    public String getMethod() {
        logger.info("getMethod()");
        return "ch02/content";
    }

    @RequestMapping(value = "/ch02/postMethod", method = RequestMethod.POST)
    public String postMethod() {
        logger.info("postMethod()");
        return "ch02/content";
    }

    @RequestMapping(value = "/ch02/join", method = RequestMethod.GET)
    public String joinForm() {
        logger.info("joinForm()");
        return "ch02/joinForm";
    }

    @RequestMapping(value = "/ch02/join", method = RequestMethod.POST)
    public String join() {
        logger.info("join()");
        return "ch02/content";
    }
}
