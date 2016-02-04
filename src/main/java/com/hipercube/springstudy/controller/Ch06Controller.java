package com.hipercube.springstudy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;

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
public class Ch06Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch05Controller.class);

    @RequestMapping("/ch06/content")
    public String content() {
        return "ch06/content";
    }

    @RequestMapping("/ch06/ppt")
    public String ppt() {
        return "ch06/ppt";
    }

    @RequestMapping("/ch06/method1")
    public void method1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filePath = request.getServletContext().getRealPath("/resources/image/photo1.jpg");
        String mimeType = request.getServletContext().getMimeType("/resources/image/photo1.jpg");

        response.setContentType(mimeType);
        ServletOutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(filePath);

        byte[] data = new byte[1024];
        int readBytes = -1;
        while ((readBytes = fis.read(data)) != -1) {
            os.write(data, 0, readBytes);
        }
        os.flush();
        os.close();
        fis.close();
    }

    @RequestMapping("/ch06/method2")
    public String method2(String mid, String mpassword, HttpSession session) {
        session.setAttribute("sessionMid", mid);
        return "ch06/content";
    }

    @RequestMapping("/ch06/method3")
    public String method2(HttpSession session) {
        session.removeAttribute("sessionMid");
        return "ch06/content";
    }
}
