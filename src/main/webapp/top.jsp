<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/5 0005
  Time: 上午 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.wht.domain.User" %>
<html>
<head>
    <title>Title</title>
    <link href="css/css.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<img src="images/logo.jpg" width="300" height="225"/>
<div id="top_right">
    <table>
        <tr>
            <td><img src="images/cart.jpg" width="25" height="25"/><a href="cart.jsp">购物车</a>｜帮助中心｜我的账户｜<a href="exit">用户退出</a></td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr>
            <td>
                <%
                    Object obj = session.getAttribute("user");
                    if (obj != null) {
                %>
                <%=((User) obj).getUserName()%>
                <%
                    }
                %>
            </td>
        </tr>
    </table>
</div>
<div id="nav">
    <ul>
        <li><a href="">文学</a>&nbsp;&nbsp;</li>
        <li><a href="">生活</a>&nbsp;&nbsp;</li>
        <li><a href="">计算机</a>&nbsp;&nbsp;</li>
        <li><a href="">外语</a>&nbsp;&nbsp;</li>
        <li><a href="">经营</a>&nbsp;&nbsp;</li>
        <li><a href="">励志</a>&nbsp;&nbsp;</li>
        <li><a href="">社科</a>&nbsp;&nbsp;</li>
        <li><a href="">学术</a>&nbsp;&nbsp;</li>
        <li><a href="">少儿</a>&nbsp;&nbsp;</li>
        <li><a href="">艺术</a>&nbsp;&nbsp;</li>
        <li><a href="">原版</a>&nbsp;&nbsp;</li>
        <li><a href="">科技</a>&nbsp;&nbsp;</li>
        <li><a href="">考试</a>&nbsp;&nbsp;</li>
        <li><a href="">生活百科</a>&nbsp;&nbsp;</li>
        <li><span style="font-size: 6px;"><a href="">全部商品目录</a></span></li>
    </ul>
</div>
<div id="search">
    <form action="search.do" method="post">Search<input value="请输入书名" name="name"/><input type="submit" value="搜索"/></form>
</div>
</body>
</html>
