<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index.jsp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/app.js"></script>
</head>
<body>
<div id="pageWrapper">
    <div id="header">
        <a href="ch01/content" target="contentCenter">
            <img src="${pageContext.request.contextPath}/resources/image/home_top.jpg"/>
        </a>
    </div>

    <div id="content">
        <div id="contentLeft">
            <div id="info">
                <div id="info1">
                    <h3>Spring Framework</h3>
                </div>
                <hr/>
                <div id="info2">
                    <table>
                        <tr>
                            <td>
                                <c:if test="${sessionMid == null}">
                                    <span id="mid">Who are you?</span>
                                </c:if>
                                <c:if test="${sessionMid != null}">
                                    <span id="mid">${sessionMid}</span>
                                </c:if>
                            </td>
                            <td>
                                <img src="${pageContext.request.contextPath}/resources/image/member_num.png"/>
                                <br/>
                                <span id="totalMemberNum">1</span>
                            </td>
                        </tr>
                    </table>
                </div>
                <hr/>
                <div id="info3">
                    <p>채팅하기</p>
                </div>
            </div>

            <div id="bookIndex">
                <h4 class="chapter">Ch01. <a href="ch01/content" target="contentCenter">개발 환경 구축</a></h4>
                <hr/>
                <h4 class="chapter">Ch02. <a href="ch02/content" target="contentCenter">컨트롤러와 요청매핑</a></h4>
                <hr/>
                <h4 class="chapter">Ch03. <a href="ch03/content" target="contentCenter">요청 파라미터</a></h4>
                <hr/>
                <h4 class="chapter">Ch04. <a href="ch04/content" target="contentCenter">헤더/쿠키</a></h4>
                <hr/>
                <h4 class="chapter">Ch05. <a href="ch05/content" target="contentCenter">뷰로 데이터 전달</a></h4>
                <hr/>
                <h4 class="chapter">Ch06. <a href="ch06/content" target="contentCenter">매개변수/리턴 타입</a></h4>
                <hr/>
                <h4 class="chapter">Ch07. <a href="ch07/content" target="contentCenter">폼관련 커스텀 태그</a></h4>
                <hr/>
                <h4 class="chapter">Ch08. <a href="ch08/content" target="contentCenter">값 검증/에러 메시지</a></h4>
                <hr/>
                <h4 class="chapter">Ch09. <a href="ch09/content" target="contentCenter">파일 업로드/다운로드</a></h4>
                <hr/>
                <h4 class="chapter">Ch10. <a href="ch10/content" target="contentCenter">의존성 주입</a></h4>
                <hr/>
                <h4 class="chapter">Ch11. <a href="ch11/content" target="contentCenter">데이터베이스 연동</a></h4>
                <hr/>
                <h4 class="chapter">Ch12. <a href="ch12/content" target="contentCenter">ORM 연동</a></h4>
                <hr/>
                <h4 class="chapter">Ch13. <a href="ch13/content" target="contentCenter">AOP/트랜잭/예외처리</a></h4>
                <hr/>
                <h4 class="chapter">Ch14. <a href="ch14/content" target="contentCenter">단위 테스트</a></h4>
                <hr/>
                <h4 class="chapter">Ch15. <a href="ch15/content" target="contentCenter">웹소켓</a></h4>
                <hr/>
                <h4 class="chapter">Ch16. <a href="ch16/list" target="contentCenter">최종실습(포토게시판)</a></h4>
                <hr/>
            </div>
        </div>
        <iframe id="contentCenter" name="contentCenter" src="ch01/content" frameborder="0" border="0"
                cellspacing="0"></iframe>
    </div>

    <hr/>

    <div id="footer">
        <p>Spring Framework</p>
    </div>
</div>
</body>
</html>
