package com.hipercube.springstudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
public class Ch04Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch04Controller.class);

    @RequestMapping("/ch04/content")
    public String content() {
        return "ch04/content";
    }

    @RequestMapping("/ch04/ppt")
    public String ppt() {
        return "ch04/ppt";
    }

    @RequestMapping("/ch04/method1")
    public String method1(@RequestHeader("User-Agent") String userAgent) {
        logger.info("User-Agent: " + userAgent);
        return "ch04/content";
    }

    @RequestMapping("/ch04/method2")
    public String method2(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("memberId", "white");
        Cookie cookie2 = new Cookie("loginStatus", "ok");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "ch04/content";
    }

    @RequestMapping("/ch04/method3")
    public String method3(@CookieValue String memberId, @CookieValue("loginStatus") String status) {
        logger.info("memberId: " + memberId);
        logger.info("loginStatus: " + status);
        return "ch04/content";
    }
}
