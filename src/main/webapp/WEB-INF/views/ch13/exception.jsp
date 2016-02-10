<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ page
        import="com.hipercube.springstudy.exception.Ch13NotFoundAccountException, org.springframework.web.servlet.NoHandlerFoundException" %>

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
    <h3>AOP</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>예외 처리</h4></div>
        <div class="sector_content">
            <%if (exception instanceof Ch13NotFoundAccountException) {%>
            <img src="${pageContext.request.contextPath}/resources/image/NotFoundAccount.png" width="500"/>
            <%} else if (exception instanceof RuntimeException) {%>
            <img src="${pageContext.request.contextPath}/resources/image/500.png" width="500"/>
            <%} else if (response.getStatus() == 404) {%>
            <img src="${pageContext.request.contextPath}/resources/image/404.png" width="500"/>
            <%} %>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
</div>
</body>
</html>