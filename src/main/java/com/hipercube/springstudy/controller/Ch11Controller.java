package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch11Board;
import com.hipercube.springstudy.dto.Ch11Member;
import com.hipercube.springstudy.service.Ch11Service;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
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
public class Ch11Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch11Controller.class);


    @Autowired
    private Ch11Service ch11Service;

    @RequestMapping("/ch11/content")
    public String content() {
        return "ch11/content";
    }

    @RequestMapping("/ch11/ppt")
    public String ppt() {
        return "ch11/ppt";
    }

    @RequestMapping(value = "/ch11/join", method = RequestMethod.POST)
    public void join(Ch11Member member, HttpServletResponse response) throws Exception {
        ch11Service.join(member);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "success");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }

    @RequestMapping(value = "/ch11/logout")
    public void logout(HttpServletResponse response, HttpSession session) throws Exception {
        session.removeAttribute("sessionMid");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "success");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }

    @RequestMapping("/ch11/boardList")
    public String boardList(Model model) {
        List<Ch11Board> list = ch11Service.getBoardList();
        model.addAttribute("list", list);
        return "ch11/boardList";
    }

    @RequestMapping(value = "/ch11/boardWrite", method = RequestMethod.GET)
    public String boardWriteForm() {
        return "ch11/boardWriteForm";
    }

    @RequestMapping(value = "/ch11/boardWrite", method = RequestMethod.POST)
    public String boardWrite(Ch11Board board) {
        Integer bno = ch11Service.boardWrite(board);
        logger.info("bno: " + bno);
        return "redirect:/ch11/boardList";
    }

    @RequestMapping(value = "/ch11/boardDetail")
    public String boardDetail(int bno, Model model) {
        Ch11Board board = ch11Service.getBoard(bno);
        model.addAttribute("board", board);
        return "ch11/boardDetail";
    }
}
