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
    <h3>매개변수/리턴 타입</h3>
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
        <div class="sector_title"><h4><span class="no">Sec02. </span>HttpServletRequest, HttpServletResponse</h4></div>
        <div class="sector_content">
            <a class="button" href="javascript:method1()">그림 가져오기</a> <br/>
            <xmp>$("#sec02_result").append('<img src="method1" width="200"/>');</xmp>
            <br/>
            <script>
                function method1() {
                    $("#sec02_result").append('<img src="method1" width="200"/>');
                }
            </script>
        </div>
        <div id="sec02_result" class="sector_result"></div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec03. </span>HttpSession</h4></div>
        <div class="sector_content">
            <c:if test="${sessionMid == null}">
                <form method="post" action="method2">
                    <table style="width:auto;">
                        <tr>
                            <th style="width:100px">mid</th>
                            <td><input type="text" name="mid" value="spring" readonly="readonly"/></td>
                        </tr>
                        <tr>
                            <th style="width:100px">mpassword</th>
                            <td><input type="password" name="mpassword" value="12345" readonly="readonly"/></td>
                        </tr>
                    </table>
                    <input class="button" type="submit" value="로그인"/>
                </form>
                <xmp>
                    <form method="post" action="method2">
                </xmp>
                <script>
                    $("#mid", window.parent.document).text("Who are you?");
                </script>
            </c:if>
            <c:if test="${sessionMid != null}">
                <a class="button" href="method3">로그아웃</a>
                <xmp><a href="method3"></xmp>
                <script>
                    $("#mid", window.parent.document).text("${sessionMid}");
                </script>
            </c:if>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec04. </span>Model</h4></div>
        <div class="sector_content">Ch05 참조</div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec05. </span>Errors 또는 BindingResult</h4></div>
        <div class="sector_content">Ch08 참조</div>
    </div>
</div>
</body>
</html>