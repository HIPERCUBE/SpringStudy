<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/content.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
</head>
<body>
<div id="header">
    <h3>요청 파라미터 / 헤더 읽기</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>이론</h4></div>
        <div class="sector_content">
            <a class="button" href="ppt">PPT 보기</a>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec02. </span>요청 파라미터 읽기</h4></div>
        <div class="sector_content">
            <a class="button" href="method1?param1=문자열&param2=5&param3=3.14&param4=true&param5=2015-12-05">요청 파라미터
                전송</a> <br/>
            <xmp><a href="method1?param1=문자열&param2=5&param3=3.14&param4=true&param5=2015-12-05"></xmp>
            <br/>
            <form method="post" action="method1">
                param1: <input type="text" name="param1" value="문자열" readonly/><br/>
                param2: <input type="text" name="param2" value="5" readonly/><br/>
                param3: <input type="text" name="param3" value="3.14" readonly/><br/>
                param4: <input type="radio" name="param4" value="true" checked/>true <input type="radio" name="param4"
                                                                                            value="false"/>false<br/>
                param5: <input type="date" name="param5" value="2015-12-05"/><br/>
                <input class="button" type="submit" value="요청 파라미터 전송"/>
            </form>
            <xmp>
                <form method="post" action="method1">...</form>
            </xmp>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec03. </span>요청 파라미터와 매개변수 이름이 다를 경우</h4></div>
        <div class="sector_content">
            <a class="button" href="method2?param1=문자열&param2=5&param3=3.14&param4=true">요청 파라미터 전송</a> <br/>
            <xmp><a href="method2?param1=문자열&param2=5&param3=3.14&param4=true"></xmp>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec04. </span>필수 요청 파라미터 지정</h4></div>
        <div class="sector_content">
            <a class="button" href="method3?param1=문자열1&param2=문자열2">올바른 요청 파라미터 전송</a> <br/>
            <xmp><a href="method3?param1=문자열1&param2=문자열2"></xmp>
            <br/>
            <a class="button" href="method3?param1=문자열1">잘못된 요청 파라미터 전송</a> <br/>
            <xmp><a href="method3?param1=문자열1"></xmp>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec05. </span>디폴트값</h4></div>
        <div class="sector_content">
            <a class="button" href="method4">요청 파라미터 없이 전송</a> <br/>
            <xmp><a href="method4"></xmp>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec06. </span>객체로 받기</h4></div>
        <div class="sector_content">
            <form method="post" action="method5">
                param1: <input type="text" name="param1" value="문자열" readonly/><br/>
                param2: <input type="text" name="param2" value="5" readonly/><br/>
                param3: <input type="text" name="param3" value="3.14" readonly/><br/>
                param4: <input type="radio" name="param4" value="true" checked/>true <input type="radio" name="param4"
                                                                                            value="false"/>false<br/>
                param5: <input type="date" name="param5" value="2015-12-05"/><br/>
                <input class="button" type="submit" value="요청 파라미터 전송"/>
            </form>
            <xmp>
                <form method="post" action="method5">...</form>
            </xmp>
        </div>
    </div>
</div>
</body>
</html>