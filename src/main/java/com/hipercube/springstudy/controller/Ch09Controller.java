package com.hipercube.springstudy.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

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
public class Ch09Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);

    @RequestMapping("/ch09/content")
    public String content() {
        return "ch09/content";
    }

    @RequestMapping("/ch09/ppt")
    public String ppt() {
        return "ch09/ppt";
    }

    @RequestMapping(value = "/ch09/upload", method = RequestMethod.POST)
    public void upload(MultipartFile attach, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // File Name
        String originalFileName = attach.getOriginalFilename();
        // Save Path
        String saveFilePath = request.getServletContext().getRealPath("/resources/upload/" + originalFileName);
        // Save File
        FileOutputStream fos = new FileOutputStream(saveFilePath);
        InputStream is = attach.getInputStream();
        int byteNo;
        byte[] data = new byte[1024];
        while ((byteNo = is.read(data)) != -1) {
            fos.write(data, 0, byteNo);
        }
        fos.flush();
        fos.close();
        is.close();

        // Response
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileName", originalFileName);
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
    }

    @RequestMapping("/ch09/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read file information
        String saveFilePath = request.getServletContext().getRealPath("/resources/upload/" + fileName);
        String fileType = request.getServletContext().getMimeType("/resources/upload/" + fileName);
        int fileSize = (int) new File(saveFilePath).length();
        // Header : File name
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // Header : File type
        response.setContentType(fileType);
        // Header : File size
        response.setContentLength(fileSize);
        // Header : Content binary
        response.setHeader("Content-Transfer-Encoding", "binary");
        // Content : File content
        FileInputStream fis = new FileInputStream(saveFilePath);
        ServletOutputStream os = response.getOutputStream();
        FileCopyUtils.copy(fis, os);
        os.flush();
        os.close();
        fis.close();
    }
}
