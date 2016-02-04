package com.hipercube.springstudy.controller;

import com.hipercube.springstudy.dto.Ch07City;
import com.hipercube.springstudy.dto.Ch07Member;
import com.hipercube.springstudy.dto.Ch07Skill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

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
public class Ch07Controller {
    private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);

    @RequestMapping("/ch07/content")
    public String content() {
        return "ch07/content";
    }

    @RequestMapping("/ch07/ppt")
    public String ppt() {
        return "ch07/ppt";
    }

    @RequestMapping(value = "/ch07/join1", method = RequestMethod.GET)
    public String join1_get(Ch07Member member) {
        logger.info("join1_get");
        return "ch07/join1";
    }

    @RequestMapping(value = "/ch07/join1", method = RequestMethod.POST)
    public String join1_post(Ch07Member member) {
        logger.info("join1_post");
        return "ch07/content";
    }

    @RequestMapping(value = "/ch07/join2", method = RequestMethod.GET)
    public String join2_get(Ch07Member member) {
        logger.info("join2_get");
        member.setMnation("대한민국");
        return "ch07/join2";
    }

    @RequestMapping(value = "/ch07/join2", method = RequestMethod.POST)
    public String join2_post(Ch07Member member) {
        logger.info("join2_post");
        logger.info("mid: " + member.getMid());
        logger.info("mname: " + member.getMname());
        logger.info("mpassword: " + member.getMpassword());
        logger.info("mnation: " + member.getMnation());
        return "ch07/content";
    }

    @RequestMapping(value = "/ch07/join3", method = RequestMethod.GET)
    public String join3_get(Ch07Member member, Model model) {
        logger.info("join3_get");

        List<String> typeList = Arrays.asList("일반회원", "기업회원", "헤드헌터회원");
        List<String> jobList = Arrays.asList("학생", "개발자", "디자이너");
        List<Ch07City> cityList = Arrays.asList(
                new Ch07City("서울", "1"),
                new Ch07City("부산", "2"),
                new Ch07City("광주", "3"),
                new Ch07City("대구", "4"),
                new Ch07City("제주", "5"));
        model.addAttribute("typeList", typeList);
        model.addAttribute("jobList", jobList);
        model.addAttribute("cityList", cityList);

        member.setMtype("기업회원");
        member.setMjob("개발자");
        member.setMcity("5");

        return "ch07/join3";
    }

    @RequestMapping(value = "/ch07/join3", method = RequestMethod.POST)
    public String join3_post(Ch07Member member) {
        logger.info("join3_post");
        logger.info("mtype: " + member.getMtype());
        logger.info("mjob: " + member.getMjob());
        logger.info("mcity: " + member.getMcity());
        return "ch07/content";
    }

    @RequestMapping(value = "/ch07/join4", method = RequestMethod.GET)
    public String join4_get(Ch07Member member, Model model) {
        logger.info("join4_get");

        List<String> languageList = Arrays.asList("C", "C++", "Java", "JavaScrip");
        List<Ch07Skill> skillList = Arrays.asList(
                new Ch07Skill("JavaFX", "1"),
                new Ch07Skill("Servlet/JSP", "2"),
                new Ch07Skill("Spring", "3"));
        model.addAttribute("languageList", languageList);
        model.addAttribute("skillList", skillList);

        member.setMlanguage(new String[]{"Java", "JavaScript"});
        member.setMskill(new String[]{"2", "3"});

        return "ch07/join4";
    }

    @RequestMapping(value = "/ch07/join4", method = RequestMethod.POST)
    public String join4_post(Ch07Member member) {
        logger.info("join4_post");
        logger.info("mlanguage: " + Arrays.toString(member.getMlanguage()));
        logger.info("mskill: " + Arrays.toString(member.getMskill()));
        return "ch07/content";
    }

    @RequestMapping(value = "/ch07/join5", method = RequestMethod.GET)
    public String join5_get(Ch07Member member, Model model) {
        logger.info("join5_get");

        List<String> typeList = Arrays.asList("일반회원", "기업회원", "헤드헌터회원");
        List<Ch07City> cityList = Arrays.asList(
                new Ch07City("서울", "1"),
                new Ch07City("부산", "2"),
                new Ch07City("광주", "3"),
                new Ch07City("대구", "4"),
                new Ch07City("제주", "5"));
        model.addAttribute("typeList", typeList);
        model.addAttribute("cityList", cityList);

        member.setMtype("기업회원");
        member.setMcity("5");

        return "ch07/join5";
    }

    @RequestMapping(value = "/ch07/join5", method = RequestMethod.POST)
    public String join5_post(Ch07Member member) {
        logger.info("join5_post");
        logger.info("mtype: " + member.getMtype());
        logger.info("mcity: " + member.getMcity());
        return "ch07/content";
    }
}