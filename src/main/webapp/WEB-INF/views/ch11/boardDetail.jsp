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
    <style type="text/css">
        span {
            display: inline-block;
            margin: 2px 10px;
        }

        span.title {
            margin: 2px 10px;
            border: 1px solid darkgray;
            background: lightgray;
            width: 70px;
            text-align: center;
            color: black;
        }

        pre {
            margin: 10px;
            border: 1px solid darkgray;
            padding: 10px;
            width: 90%;
            height: 100px;
            font-size: 12px;
        }

        #buttonGroup {
            margin: 10px;
            text-align: center;
        }

        #buttonGroup a {
            display: inline-block;
            width: 70px;
            line-height: 30px;
            text-decoration: none;
            font-size: small;
            color: white;
            border: 1px solid darkgray;
            background-color: gray;
            font-weight: bold;
        }

        #buttonGroup a:hover {
            color: black;
            background-color: lightgray;
        }
    </style>
</head>
<body>
<div id="header">
    <h3>데이터베이스 연동</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>게시물 보기</h4></div>
        <div class="sector_content">
            <div>
                <span class="title">번호:</span>
                <span class="content">${board.bno}</span> <br/>

                <span class="title">제목:</span>
                <span class="content">${board.btitle}</span> <br/>

                <span class="title">글쓴이:</span>
                <span class="content">${board.mid}</span> <br/>

                <span class="title">날짜:</span>
                <span class="content">${board.bdate}</span> <br/>
            </div>

            <div>
                <span class="title">내용:</span> <br/>
                <pre>${board.bcontent}</pre>
            </div>

            <div id="buttonGroup">
                <a href="boardList?bno=${bno}">목록</a>
                <%--
                <a href="boardUpdateForm?bno=${board.bno}">수정</a>
                <a href="boardDelete?bno=${board.bno}">삭제</a>
                --%>
            </div>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>