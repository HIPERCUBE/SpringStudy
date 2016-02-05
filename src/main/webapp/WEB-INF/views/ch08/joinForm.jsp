<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form commandName="ch08Member">
    <table>
        <tr>
            <th style="width:100px">이메일</th>
            <td style="text-align: left;"><form:input path="memail"/><form:errors path="memail" cssClass="error"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td style="text-align: left;"><form:input path="mname"/><form:errors path="mname" cssClass="error"/></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td style="text-align: left;"><form:input path="mpassword"/><form:errors path="mpassword"
                                                                                     cssClass="error"/></td>
        </tr>
    </table>
    <a class="button" href="javascript:join()">가입</a>
</form:form>
<script>
    function join() {
        console.log($("#ch08Member").serialize());
        $.ajax({
            url: "join",
            method: "POST",
            data: $("#ch08Member").serialize(),
            success: function (data) {
                $("#sec01_result").html(data);
            }
        });
    }
</script>
<xmp>$.ajax({url:"join",method:"POST",data:$("#ch08Member").serialize(),success:function(data) {...});</xmp>