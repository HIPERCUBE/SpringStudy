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
    <h3>헤더 / 쿠키 읽기</h3>
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
        <div class="sector_title"><h4><span class="no">Sec02. </span>헤더 읽기</h4></div>
        <div class="sector_content">
            <a class="button" href="method1">브라우저 종류</a> <br/>
            <xmp><a href="method1"></xmp>
        </div>
    </div>
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec03. </span>쿠키 읽기</h4></div>
        <div class="sector_content">
            <a class="button" href="method2">쿠키 저장</a> <br/>
            <xmp><a href="method2"></xmp>
            <br/>
            <a class="button" href="method3">쿠키 읽기</a> <br/>
            <xmp><a href="method3"></xmp>
            </li>
        </div>
    </div>
</body>
</html>