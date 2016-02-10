package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch13Account;
import com.hipercube.springstudy.service.Ch11Service;
import com.hipercube.springstudy.service.Ch13Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Copyright (c) 2/10/16 Joowon Ryoo
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
public class Ch13Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch13Controller.class);

    @Autowired
    private Ch11Service ch11Service;

    @Autowired
    private Ch13Service ch13Service;

    @RequestMapping("/ch13/content")
    public String content(Model model) {
        List<Ch13Account> list = ch13Service.getAccountList();
        model.addAttribute("list", list);
        return "ch13/content";
    }

    @RequestMapping("/ch13/ppt")
    public String ppt() {
        return "ch13/ppt";
    }

    @RequestMapping("/ch13/runtimeCheck")
    public String runtimeCheck() {
        return "ch13/content";
    }

    @RequestMapping("/ch13/boardList")
    public String boardList(Model model) {
        model.addAttribute("list", ch11Service.getBoardList());
        return "ch13/boardList";
    }

    @RequestMapping("/ch13/accountTransfer")
    public String accountTransfer(int fromAno, int toAno, int amount) {
        ch13Service.transfer(fromAno, toAno, amount);
        return "redirect:/ch13/content";
    }
}
