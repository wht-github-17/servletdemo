<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/25 0025
  Time: 下午 2:49
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
    首页>购物车
    <table>
        <tr>
            <td>序号</td>
            <td>商品名称</td>
            <td>价格</td>
            <td>数量</td>
            <td>库存</td>
            <td>小计</td>
            <td>取消</td>
        </tr>
        <c:forEach items="${cart}" var="entry" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${entry.key.name}</td>
                <td>${entry.key.price}</td>
                <td><input type="button" value="-"/>
                    <input type="text" value="${entry.value}"/>
                    <input type="button" value="+"/>
                </td>
                <td>${entry.key.pnum}</td>
                <td>${entry.key.price*entry.value}</td>
                <td><a href="${pageContext.request.contextPath}/changeCart?id=${entry.key.id}&count=0">
                    <img src="${pageContext.request.contextPath}/images/del.jpg" width="28" height="28"/></a></td>
            </tr>
            <c:set value="${total+entry.key.price*entry.value}" var="total"/>
        </c:forEach>
        <tr>
            <td>合计：${total}元</td>
        </tr>
        <tr>
            <td><input type="button" value="继续购物"/></td>
            <td><input type="button" value="结算"/></td>
            <script>
                $(":button:eq(1)").click(function(){
                    document.href="${pageContext.request.contextPath}/order.jsp";
                });
            </script>
        </tr>
    </table>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>
