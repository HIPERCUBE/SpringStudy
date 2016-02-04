<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form commandName="ch07Member">
    <table style="width:auto;">
        <tr>
            <th style="width:100px">언어</th>
            <td style="width:300px;text-align:left"><form:checkboxes path="mlanguage" items="${languageList}"
                                                                     style="margin-left:10px"/></td>
        </tr>
        <tr>
            <th style="width:100px">스킬</th>
            <td style="width:300px;text-align:left"><form:checkboxes path="mskill" items="${skillList}"
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
                <th style="width:100px">언어</th>
                <td style="width:300px;text-align:left"><form:checkboxes path="mlanguage" items="${languageList}"
                                                                         style="margin-left:10px"/></td>
            </tr>
            <tr>
                <th style="width:100px">스킬</th>
                <td style="width:300px;text-align:left"><form:checkboxes path="mskill" items="${skillList}"
                                                                         itemLabel="label" itemValue="value"
                                                                         style="margin-left:10px"/></td>
            </tr>
        </table>
        <input class="button" type="submit" value="가입"/>
    </form:form>
</xmp>