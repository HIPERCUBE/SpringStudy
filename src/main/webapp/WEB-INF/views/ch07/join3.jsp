<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form commandName="ch07Member">
    <table style="width:auto;">
        <tr>
            <th style="width:100px">타입</th>
            <td style="width:200px;text-align:left">
                <form:select path="mtype" items="${typeList}" style="width:100%"/>
            </td>
        </tr>
        <tr>
            <th>직업</th>
            <td style="text-align:left">
                <form:select path="mjob" style="width:100%">
                    <option>---선택하세요---</option>
                    <form:options items="${jobList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>도시</th>
            <td style="text-align:left"><form:select path="mcity" items="${cityList}" itemLabel="label"
                                                     itemValue="value" style="width:100%"/></td>
        </tr>
    </table>
    <input class="button" type="submit" value="가입"/>
</form:form>

<xmp>
    <form:form commandName="ch07Member">
        <table style="width:auto;">
            <tr>
                <th style="width:100px">타입</th>
                <td style="width:200px;text-align:left"><form:select path="mtype" items="${typeList}"
                                                                     style="width:100%"/></td>
            </tr>
            <tr>
                <th>직업</th>
                <td style="text-align:left">
                    <form:select path="mjob" style="width:100%">
                        <option>---선택하세요---</option>
                        <form:options items="${jobList}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <th>도시</th>
                <td style="text-align:left"><form:select path="mcity" items="${cityList}" itemLabel="label"
                                                         itemValue="value" style="width:100%"/></td>
            </tr>
        </table>
        <input class="button" type="submit" value="가입"/>
    </form:form>
</xmp>