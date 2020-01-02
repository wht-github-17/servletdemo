<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20 0020
  Time: 下午 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="top.jsp"/>
<div>
    <table>
        <tr>
            <td>编号</td>
            <td>名称</td>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><a href="searchById.do?id=${product.id}">详情</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>
