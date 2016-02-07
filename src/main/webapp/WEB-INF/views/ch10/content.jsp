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
    <h3>의존성 주입</h3>
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
        <div class="sector_title"><h4><span class="no">Sec01. </span>XML을 이용한 DI 설정</h4></div>
        <div class="sector_content">
            <a class="button" href="javascript:boardList1()">게시물 목록</a> <br/>
            <xmp>$.ajax({url:"boardList1",success:function(data){$("#sec01_result").html(data);}});</xmp>
            <script type="text/javascript">
                function boardList1() {
                    $.ajax({
                        url: "boardList1",
                        success: function (data) {
                            $("#sec01_result").html(data);
                        }
                    });
                }
            </script>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec02. </span>Annotation을 이용한 DI 설정</h4></div>
        <div class="sector_content">
            <a class="button" href="javascript:boardList2()">게시물 목록</a> <br/>
            <xmp>$.ajax({url:"boardList2",success:function(data){$("#sec01_result").html(data);}});</xmp>
            <script type="text/javascript">
                function boardList2() {
                    $.ajax({
                        url: "boardList2",
                        success: function (data) {
                            $("#sec02_result").html(data);
                        }
                    });
                }
            </script>
        </div>
        <div id="sec02_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>