<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="/pager-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>gender</td>
        <td>email</td>
        <td>telephone</td>
        <td>state</td>
        <td>role</td>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="s" >
        <c:if test="${s.index%2==0}" var="result">
            <tr style="background-color: aliceblue">
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td>${user.telephone}</td>
                <td>
                    <c:if test="${user.state==0}" var="result">
                        未激活
                    </c:if>
                    <c:if test="${!result}">
                        激活
                    </c:if>
                </td>
                <td>${user.role}</td>
            </tr>
        </c:if>
        <c:if test="${!result}">
        <tr style="background-color: antiquewhite">
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>${user.gender}</td>
            <td>${user.email}</td>
            <td>${user.telephone}</td>
            <td>
                <c:if test="${user.state==0}" var="result">
                    未激活
                </c:if>
                <c:if test="${!result}">
                    激活
                </c:if>
            </td>
            <td>${user.role}</td>
        </tr>
        </c:if>
    </c:forEach>
</table>
<c:forEach begin="1" end="10" step="2" var="i">
    ${i}
</c:forEach>
<c:set var="u"  scope="page" value="kitty"/>
${u}
<jsp:useBean id="user1" class="com.wht.domain.User" scope="request"/>
<jsp:setProperty name="user1" property="userName" value="kitty"/>
${user1.userName}
<c:set target="${user1}" property="userName" value="cat"/>
<jsp:getProperty name="user1" property="userName"/>
<c:out value="${user1.userName}"/>
<c:choose>
    <c:when test="${empty param.username}">
        unKnown user.
    </c:when>
    <c:when test="${param.username=='itcast'}">
        ${param.username} is manager.
    </c:when>
    <c:otherwise>
        ${param.username} is employee.
    </c:otherwise>
</c:choose>
<p:pager pageIndex="" pageSize="" recordCount="" submitUrl="" style=""/>
</body>
</html>
