<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<table>
    <tr>
        <th style="width:50px">번호</th>
        <th>제목</th>
        <th>내용</th>
        <th style="width:60px">글쓴이</th>
        <th style="width:80px">날짜</th>
    </tr>

    <tr>
        <td>${board.no}</td>
        <td>${board.title}</td>
        <td>${board.content}</td>
        <td>${board.writer}</td>
        <td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/></td>
    </tr>
</table>

