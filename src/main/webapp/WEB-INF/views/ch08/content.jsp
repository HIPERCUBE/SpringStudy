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
    <h3>값 검증 / 에러 메시지</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec00. </span>이론</h4></div>
        <div class="sector_content">
            <a class="button" href="ppt">PPT 보기</a>
        </div>
        <div id="sec00_result" class="sector_result"></div>
    </div>
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>값 검증 및 에러 메시지</h4></div>
        <div class="sector_content">
            <a class="button" href="javascript:joinForm()">폼 요청</a>
            <xmp>$.ajax({url:"joinForm", success:function(data) { $("#sec01_result").html(data); }});</xmp>
            <script>
                function joinForm() {
                    $.ajax({
                        url: "join",
                        success: function (data) {
                            $("#sec01_result").html(data);
                        }
                    });
                }
            </script>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>