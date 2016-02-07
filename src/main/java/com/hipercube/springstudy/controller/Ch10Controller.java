package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch10Board;
import com.hipercube.springstudy.service.Ch10Service1;
import com.hipercube.springstudy.service.Ch10Service2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Copyright (c) 2/7/16 Joowon Ryoo
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
public class Ch10Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);

    private Ch10Service1 ch10Service1;

    public void setCh10Service1(Ch10Service1 ch10Service1) {
        logger.info("setCh10Service1()");
        this.ch10Service1 = ch10Service1;
    }

    @Autowired
    private Ch10Service2 ch10Service2;

    @RequestMapping("/ch10/content")
    public String content() {
        return "ch10/content";
    }

    @RequestMapping("/ch10/ppt")
    public String ppt() {w
        return "ch10/ppt";
    }

    @RequestMapping("/ch10/boardList1")
    public String boardList1(Model model) {
        List<Ch10Board> boardList = ch10Service1.getBoardList();
        model.addAttribute("list", boardList);
        return "ch10/boardList";
    }

    @RequestMapping("/ch10/boardList2")
    public String boardList2(Model model) {
        List<Ch10Board> boardList = ch10Service2.getBoardList();
        model.addAttribute("list", boardList);
        return "ch10/boardList";
    }
}
