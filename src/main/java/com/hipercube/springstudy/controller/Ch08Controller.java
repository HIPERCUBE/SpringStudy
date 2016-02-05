package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch08Member;
import com.hipercube.springstudy.dto.Ch08MemberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright (c) 2/6/16 Joowon Ryoo
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
public class Ch08Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);

    @RequestMapping("/ch08/content")
    public String content() {
        return "ch08/content";
    }

    @RequestMapping("/ch08/ppt")
    public String ppt() {
        return "ch08/ppt";
    }

    @RequestMapping(value = "/ch08/join", method = RequestMethod.GET)
    public String joinForm(Ch08Member member) {
        return "ch08/joinForm";
    }

    @RequestMapping(value = "/ch08/join", method = RequestMethod.POST)
    public String joinForm(Ch08Member member, Errors errors) {
        new Ch08MemberValidator().validate(member, errors);
        if (errors.hasErrors()) {
            return "ch08/joinForm";
        }

        logger.info("memail: " + member.getMemail());
        logger.info("mname: " + member.getMname());
        logger.info("mpassword: " + member.getMpassword());

        return "ch08/joinResult";
    }
}
