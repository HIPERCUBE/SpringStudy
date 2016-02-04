<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form commandName="ch07Member">
    <table style="width:auto;">
        <tr>
            <th style="width:100px">타입</th>
            <td style="width:300px;text-align:left"><form:radiobuttons path="mtype" items="${typeList}"
                                                                       style="margin-left:10px"/></td>
        </tr>
        <tr>
            <th style="width:100px">도시</th>
            <td style="width:300px;text-align:left"><form:radiobuttons path="mcity" items="${cityList}"
                                                                       itemLabel="label" itemValue="value"
                                                                       style="margin-left:10px"/></td>
        </tr>
    </table>
    <input class="button" type="submit" value="가입"/>
</form:form>

<xmp>
    <form:form commandName="ch07Member">
        <table style="width:auto;">
            <tr>
                <td style="width:100px">타입</td>
                <td style="width:300px;text-align:left"><form:radiobuttons path="mtype" items="${typeList}"
                                                                           style="margin-left:10px"/></td>
            </tr>
            <tr>
                <td>도시</td>
                <td><form:radiobuttons path="mcity" items="${cityList}" itemLabel="label" itemValue="value"
                                       style="margin-left:10px"/></td>
            </tr>
        </table>
        <input class="button" type="submit" value="가입"/>
    </form:form>
</xmp>