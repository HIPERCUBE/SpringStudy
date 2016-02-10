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
    <h3>AOP / 트랜잭션 / 예외 처리</h3>
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
        <div class="sector_title"><h4><span class="no">Sec02. </span>실행 시간 측정</h4></div>
        <div class="sector_content">
            <a class="button" href="runtimeCheck">실행시간 측정</a>
        </div>
        <div id="sec02_result" class="sector_result">
            <c:if test="${runtime != null}">
                ${runtime} 나노초
            </c:if>
        </div>
    </div>
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec03. </span>로그인 체크</h4></div>
        <div class="sector_content">
            <a class="button" href="boardList">게시물 목록</a>
        </div>
        <div id="sec03_result" class="sector_result">
            <c:if test="${loginNeed != null}">
                <span class="error">${loginNeed}</span>
                <a class="button" href="${pageContext.request.contextPath}/ch11/content">로그인</a>
            </c:if>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec04. </span>트랜잭션</h4></div>
        <div class="sector_content">
            <form id="accountTransferForm" method="post" action="accountTransfer">
                <table style="width:auto">
                    <tr>
                        <th style="width:150px">출금 계좌</th>
                        <td><input id="fromAccount" type="text" name="fromAno" value="1" readonly/></td>
                    </tr>
                    <tr>
                        <th>입금 계좌</th>
                        <td><input id="toAccount" type="text" name="toAno" value="2"/></td>
                    </tr>
                    <tr>
                        <th>이체 금액</th>
                        <td><input id="amount" type="text" name="amount" value="100000" readonly/></td>
                    </tr>
                </table>
                <input class="button" type="submit" value="이체하기"/>
            </form>
        </div>
        <div id="sec03_result" class="sector_result">
            <table>
                <tr>
                    <th style="width:50px">번호</th>
                    <th style="width:100px">소유주</th>
                    <th>잔고</th>
                </tr>

                <c:forEach var="account" items="${list}">
                    <tr>
                        <td>${account.ano}</td>
                        <td>${account.owner}</td>
                        <td>${account.balance}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec05. </span>예외처리</h4></div>
        <div class="sector_content">
            <a class="button" href="accountTransfer?fromAno=1&toAno=3&amount=100000">계좌번호 오류</a>
            <xmp>
                <a class="button" href="accountTransfer?fromAno=1&toAno=3&amount=100000">
            </xmp>
            <br/>
            <a class="button" href="notmapping">404</a>
            <xmp>
                [web.xml]
                <error-page>
                    <error-code>404</error-code>
                    <location>/WEB-INF/views/ch13/exception.jsp</location>
                </error-page>
            </xmp>
        </div>
        <div id="sec03_result" class="sector_result">
            <c:if test="${loginNeed != null}">
                <span class="error">${loginNeed}</span>
                <a class="button" href="${pageContext.request.contextPath}/ch11/content">로그인</a>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>