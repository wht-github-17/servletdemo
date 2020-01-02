<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/30 0030
  Time: 上午 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"/>
    <script src="js/bootstrap.min.js"/>
</head>
<body>
<jsp:include page="top.jsp"/>
首页>购物车>订单
<img/>
你好，！欢迎您来到网上书城结算中心
<table>
    <tr>
        <td>序号</td>
        <td>商品名称</td>
        <td>价格</td>
        <td>类别</td>
        <td>数量</td>
        <td>小计</td>
    </tr>
    <c:forEach items="cart" var="entry" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${entry.key.name}</td>
            <td>${entry.key.price}</td>
            <td>${entry.key.category}</td>
            <td>${entry.value}</td>
            <td>${entry.key.price*cart.value}</td>
        </tr>
        <c:set var="totalPrice" value="${totalPrice+entry.key.price*entry.value}"/>
    </c:forEach>
    合计：${totalPrice}元
</table>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label for="address" class="col-sm-2 control-label">收货地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="address" placeholder="请输入收货地址">
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">收货人</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" placeholder="请输入收货人">
        </div>
    </div>
    <div class="form-group">

        <label class="col-sm-2 control-label" for="tel">
            联系方式
        </label>
        <div class="col-sm-10">
            <input type="text" id="tel" placeholder="请输入联系方式">

        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">提交订单</button>
        </div>
    </div>
</form>
<jsp:include page="bottom.jsp"/>
</body>
</html>
