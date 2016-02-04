<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form commandName="ch07Member">
    <table style="width:auto;">
        <tr>
            <th style="width:100px">아이디</th>
            <td><form:input path="mid"/></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><form:input path="mname"/></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><form:password path="mpassword"/></td>
        </tr>
    </table>
    <form:hidden path="mnation"/>
    <input class="button" type="submit" value="가입"/>
</form:form>

<xmp>
    <form:form commandName="ch07Member">
        <table style="width:auto;">
            <tr>
                <th style="width:100px">아이디</th>
                <td><form:input path="mid"/></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><form:input path="mname"/></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><form:password path="mpassword"/></td>
            </tr>
        </table>
        <form:hidden path="mnation"/>
        <input class="button" type="submit" value="가입"/>
    </form:form>
</xmp>