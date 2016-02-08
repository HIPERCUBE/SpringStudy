package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch12Board;
import com.hipercube.springstudy.service.Ch12Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Copyright (c) 2/8/16 Joowon Ryoo
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
public class Ch12Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch12Controller.class);

    @Autowired
    private Ch12Service ch12Service;

    @RequestMapping("/ch12/content")
    public String content() {
        return "ch12/content";
    }

    @RequestMapping("/ch12/ppt")
    public String ppt() {
        return "ch12/ppt";
    }

    @RequestMapping("/ch12/boardList")
    public String boardList(Model model) {
        List<Ch12Board> list = ch12Service.getBoardList();
        model.addAttribute("list", list);
        return "ch12/boardList";
    }

    @RequestMapping(value = "/ch12/boardWrite", method = RequestMethod.GET)
    public String boardWriteForm() {
        return "ch12/boardWriteForm";
    }

    @RequestMapping(value = "/ch12/boardWrite", method = RequestMethod.POST)
    public String boardWrite(Ch12Board board) {
        Integer bno = ch12Service.boardWrite(board);
        return "redirect:/ch12/boardList";
    }

    @RequestMapping(value = "/ch12/boardDetail")
    public String boardDetail(int bno, Model model) {
        Ch12Board board = ch12Service.getBoard(bno);
        model.addAttribute("board", board);
        return "ch12/boardDetail";
    }
}
