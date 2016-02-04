<%--
  Created by IntelliJ IDEA.
  User: HIPERCUBE
  Date: 2/4/16
  Time: 3:19 PM
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
    <h3>컨트롤러와 요청매핑</h3>
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
            <h4><span class="no">Sec02. </span>GET 방식 매핑</h4>
        </div>
        <div class="sector_content">
            <a class="button" href="getMethod">getMethod() 요청</a><br/>
            <xmp><a href="getMethod">getMethod() 요청</a></xmp>
            <br/>
            <a class="button" href="postMethod">postMethod() 요청</a><br/>
            <xmp><a href="postMethod">postMethod() 요청</a></xmp>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title">
            <h4><span class="no">Sec03. </span>POST 방식 매핑</h4>
        </div>
        <div class="sector_content">
            <form method="post" action="getMethod"><input class="button" type="submit" value="getMethod() 요청"/></form>
            <xmp><form method="post" action="getMethod"><input type="submit" value="postMethod() 요청"/></form></xmp>
            <br/>
            <form method="post" action="postMethod"><input class="button" type="submit" value="postMethod() 요청"/></form>
            <xmp><form method="post" action="postMethod"><input type="submit" value="postMethod() 요청"/></form></xmp>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec04. </span>폼요청(GET)과 폼처리(POST)를 동일한 요청으로 매핑</h4></div>
        <div class="sector_content">
            <a class="button" href="javascript:fun4()">폼요청(GET)</a><br/>
            <script type="text/javascript">
                function fun4() {
                    $.ajax({
                        url: "join",
                        method: "GET",
                        success: function (data) {
                            $("#sec04_result").append(data);
                        }
                    })
                }
            </script>
            <xmp>$.ajax({ url:"join", method:"GET", success: function(data) { ... } });</xmp>
        </div>
        <div id="sec04_result" class="sector_result"></div>
    </div>

</div>
</body>
</html>
