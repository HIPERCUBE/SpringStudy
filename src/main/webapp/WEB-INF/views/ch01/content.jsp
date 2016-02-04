<%--
  Created by IntelliJ IDEA.
  User: HIPERCUBE
  Date: 2/4/16
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h3>개발 환경 구축</h3>
</div>
<div id="content">
    <div class="sector">
        <div class="sector_title">
            <h4><span class="no">Sec01. </span>이론</h4>
        </div>
        <div class="sector_content">
            <a class="button" href="ppt">PPT 보기</a>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
    <div class="sector">
        <div class="sector_title">
            <h4><span class="no">Sec02. </span>실습</h4>
        </div>
        <div class="sector_content"></div>
    </div>
</div>
</body>
</html>