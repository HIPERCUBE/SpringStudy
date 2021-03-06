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
        function loginForm() {
            $("#loginForm").show();
            $("#loginForm").find("#midError").text("");
            $("#loginForm").find("#mpasswordError").text("");
            $("#joinForm").hide();
        }

        function login() {
            var mid = $("#loginForm").find("#mid").val().trim();
            if (mid == "") {
                $("#loginForm").find("#midError").text("필수");
            }
            else {
                $("#loginForm").find("#midError").text("");
            }

            var mpassword = $("#loginForm").find("#mpassword").val().trim();
            if (mpassword == "") {
                $("#loginForm").find("#mpasswordError").text("필수");
            }
            else {
                $("#loginForm").find("#mpasswordError").text("");
            }

            if (mid != "" && mpassword != "") {
                $.ajax({
                    url: "login",
                    method: "POST",
                    data: $("#loginForm").serialize(),
                    success: function (data) {
                        if (data.result == "success") {
                            $("#loginForm").hide();
                            $("#mid", window.parent.document).text(mid);
                            $("#sec02_result").html('<a class="button" href="javascript:logout()">로그아웃</a>');
                        } else if (data.result == "fail-mid") {
                            $("#sec02_result").html("<span class='error'>아이디가 존재하지 않습니다.</span>");
                        } else if (data.result == "fail-mpassword") {
                            $("#sec02_result").html("<span class='error'>패스워드가 틀립니다.</span>");
                        }
                    },
                    error: function () {
                        $("#sec02_result").html("<span class='error'>로그인 실패</span>");
                    }
                });
            }
        }

        function logout() {
            $.ajax({
                url: "logout",
                success: function (data) {
                    if (data.result == "success") {
                        $("#loginForm").show();
                        $("#sec02_result").empty();
                        $("#mid", window.parent.document).text("Who are you?");
                    }
                }
            });
        }

        function joinForm() {
            $("#loginForm").hide();
            $("#joinForm").show();
            $("#joinForm").find("#midError").text("");
            $("#joinForm").find("#mnameError").text("");
            $("#joinForm").find("#mpasswordError").text("");
        }

        function join() {
            var mid = $("#joinForm").find("#mid").val().trim();
            if (mid == "") {
                $("#joinForm").find("#midError").text("필수");
            }
            else {
                $("#joinForm").find("#midError").text("");
            }

            var mname = $("#joinForm").find("#mname").val().trim();
            if (mname == "") {
                $("#joinForm").find("#mnameError").text("필수");
            }
            else {
                $("#joinForm").find("#mnameError").text("");
            }

            var mpassword = $("#joinForm").find("#mpassword").val().trim();
            if (mpassword == "") {
                $("#joinForm").find("#mpasswordError").text("필수");
            }
            else {
                $("#joinForm").find("#mpasswordError").text("");
            }

            if (mid != "" && mname != "" && mpassword != "") {
                $.ajax({
                    url: "join",
                    method: "POST",
                    data: $("#joinForm").serialize(),
                    success: function (data) {
                        if (data.result == "success") {
                            $("#loginForm").show();
                            $("#joinForm").hide();
                            $("#sec02_result").html("<span class='error'>회원가입 성공, 로그인하세요.</span>");
                        }
                    },
                    error: function () {
                        $("#sec02_result").html("<span class='error'>회원가입 실패</span>");
                    }
                });
            }
        }
    </script>
</head>
<body>
<div id="header">
    <h3>데이터베이스 연동</h3>
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
        <div class="sector_title"><h4><span class="no">Sec01. </span>테이블 생성</h4></div>
        <div class="sector_content">
            <xmp>
                create table member (
                mid varchar(10) primary key,
                mname varchar(10) not null,
                mpassword varchar(10) not null
                );

                create table board (
                bno int primary key,
                btitle varchar(100) not null,
                bcontent varchar(4000) not null,
                bdate date not null,
                mid varchar(10) references member(mid)
                );
            </xmp>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec02. </span>로그인</h4></div>
        <div class="sector_content">
            <form id="loginForm" <c:if test="${sessionMid!=null}">style="display:none"</c:if>>
                <table style="width:auto">
                    <tr>
                        <th style="width:100px">아이디</th>
                        <td style="width:220px;text-align:left;"><input id="mid" type="text" name="mid"/><span
                                id="midError" class="error"></span></td>
                    </tr>
                    <tr>
                        <th style="width:100px">비밀번호</th>
                        <td style="width:220px;text-align:left;"><input id="mpassword" type="password"
                                                                        name="mpassword"/><span id="mpasswordError"
                                                                                                class="error"></span>
                        </td>
                    </tr>
                </table>
                <a href="javascript:login()" class="button">로그인</a>
                <a href="javascript:joinForm()" class="button">회원가입</a>
            </form>
            <form id="joinForm" style="display:none">
                <table style="width:auto">
                    <tr>
                        <th style="width:100px">아이디</th>
                        <td style="width:220px;text-align:left;"><input id="mid" type="text" name="mid"/><span
                                id="midError" class="error"></span></td>
                    </tr>
                    <tr>
                        <th style="width:100px">이름</th>
                        <td style="width:220px;text-align:left;"><input id="mname" type="text" name="mname"/><span
                                id="mnameError" class="error"></span></td>
                    </tr>
                    <tr>
                        <th style="width:100px">비밀번호</th>
                        <td style="width:220px;text-align:left;"><input id="mpassword" type="password"
                                                                        name="mpassword"/><span id="mpasswordError"
                                                                                                class="error"></span>
                        </td>
                    </tr>
                </table>
                <a href="javascript:join()" class="button">회원가입</a>
                <a href="javascript:loginForm()" class="button">취소</a>
            </form>
        </div>
        <div id="sec02_result" class="sector_result">
            <c:if test="${sessionMid!=null}">
                <script>$("#mid", window.parent.document).text("${sessionMid}");</script>
                <a class="button" href="javascript:logout()">로그아웃</a>
            </c:if>
        </div>
    </div>

    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec03. </span>게시판</h4></div>
        <div class="sector_content">
            <a class="button" href="boardList">게시물 목록</a>
        </div>
        <div id="sec03_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>