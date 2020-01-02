<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/2 0002
  Time: 上午 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script src="js/jquery-3.2.1.min.js">
    </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<%
Cookie[] cookies=request.getCookies();

String name="";
String password="";
if(cookies!=null &&cookies.length>0) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("remeber")) {
            String v = cookie.getValue();
            String[] s = v.split("-");
            name = s[0];
            password = s[1];
        }
    }
}
%>

<jsp:include page="top.jsp"/>

<h4>首页>>个人用户登录</h4>

<div id="login">

    <img/>个人用户登录

    <form action="<%=response.encodeURL("login")%>" method="post"  class="form-inline">
        <table>

            <tr>
                <td>用户名：</td>
                <td><input name="username" value="<%=name%>"/></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码：</td>
                <td><input type="password" name="password" value="<%=password%>"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="checkbox" name="remeber" value="1"/>记住用户名<input type="checkbox" name="autoLogin" value="1"/>自动登录</td>

            </tr>
            <tr>
                <td colspan="2"><input type="submit"/></td>

            </tr>

        </table>
</form>
</div>

<div id="info">
    <p>您还没有注册？</p>
    <p>注册新会员，享受更优惠价格！</p>
    <p>千种图书，任你挑选！注册即享受丰富折扣和优惠，便宜有好货！超过万本图书任您选。</p>
    <p>超人气社区！精彩活动每一天，买卖更安心！支付宝交易超安全。</p>
    <input type="button" value="注册新会员"/>
    <script>
        $(":button").click(function(){
            location.href="register.jsp";
        });
    </script>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>
