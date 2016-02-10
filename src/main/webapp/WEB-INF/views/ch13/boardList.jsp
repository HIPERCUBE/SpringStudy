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
    <h3>데이터베이스 연동</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>게시판</h4></div>
        <div class="sector_content">
            <table>
                <tr>
                    <th style="width:50px">번호</th>
                    <th>제목</th>
                    <th style="width:100px">글쓴이</th>
                    <th style="width:80px">날짜</th>
                </tr>

                <c:forEach var="board" items="${list}">
                    <tr>
                        <td>${board.bno}</td>
                        <td>${board.btitle}</td>
                        <td>${board.mid}</td>
                        <td><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>