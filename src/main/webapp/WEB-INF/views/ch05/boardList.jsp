<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<table>
    <tr>
        <th style="width:50px">번호</th>
        <th>제목</th>
        <th style="width:60px">글쓴이</th>
        <th style="width:80px">날짜</th>
    </tr>

    <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.no}</td>
            <td><a href="javascript:boardDetail(${board.no})">${board.title}</a></td>
            <td>${board.writer}</td>
            <td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/></td>
        </tr>
    </c:forEach>
</table>

<script>
    function boardDetail(no) {
        $.ajax({
            url: "boardDetail",
            data: {no: no},
            success: function (data) {
                $("#sec02_result").html(data);
            }
        });
    }
</script>
<xmp>$.ajax({url:"boardDetail",data:{no:no},success:function(data){$("#sec02_result").html(data);}});</xmp>