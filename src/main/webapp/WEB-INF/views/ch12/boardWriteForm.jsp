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
    <script type="text/javascript">
        function boardWrite() {
            var btitle = $("#btitle").val().trim();
            if (btitle == "") {
                $("#btitleError").text("필수");
            }
            else {
                $("#btitleError").text("");
            }

            var bcontent = $("#bcontent").val().trim();
            if (bcontent == "") {
                $("#bcontentError").text("필수");
            }
            else {
                $("#bcontentError").text("");
            }

            if (btitle == "" || bcontent == "") {
                return false;
            }
        }
    </script>
</head>
<body>
<div id="header">
    <h3>ORM 연동</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>게시물 쓰기</h4></div>
        <div class="sector_content">
            <form id="boardWriteForm" method="post" onsubmit="return boardWrite()" action="boardWrite">
                <table style="width:auto">
                    <tr>
                        <th style="width:50px">제목</th>
                        <td style="width:500px;text-align:left;"><input id="btitle" type="text" name="btitle"
                                                                        style="width:90%;"/><span id="btitleError"
                                                                                                  class="error"></td>
                    </tr>
                    <tr>
                        <th style="width:50px">내용</th>
                        <td style="width:500px;text-align:left;"><textarea id="bcontent" name="bcontent" rows="5"
                                                                           style="width:90%;"></textarea><span
                                id="bcontentError" class="error"></td>
                    </tr>
                    <tr>
                        <th style="width:50px">글쓴이</th>
                        <td style="width:500px;text-align:left;"><input id="mid" type="text" name="mid"
                                                                        <c:if test="${sessionMid!=null}">value="${sessionMid}"</c:if>
                                                                        <c:if test="${sessionMid==null}">value="test"</c:if>
                                                                        style="width:90%;" readonly/></td>
                    </tr>
                </table>
                <div style="margin-top: 10px">
                    <input type="submit" class="button" value="글쓰기"/>
                    <a class="button" href="boardList">취소</a>
                </div>
            </form>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>