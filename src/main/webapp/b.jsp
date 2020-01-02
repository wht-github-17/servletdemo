<%@page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date"%>
<%@page import="com.wht.servlet.A"%>
<%@ include file="my.jsp"%>

<%! int counter = 0; %>
<%!
    String getHello(String name) {
        return "Hi," + name + "!";
    }
%>

<% Date now = new Date(); //返回%>
<html>
<head>
    <title>JSP 页面构成</title>
</head>
<!-- 这是注释,但客户端可以察看到 -->
<%-- 这也是注释,但客户端不能察看到 --%>
<body>
10.<!-- X -->
11.<%=A.b() %>
12.<!--<%=A.b()%>-->
13.<%--Y--%>
<%--<%=A.b()%>--%>
<% x=3; %>
<% int x=5; %>
<%! int x=7; %>
x = <%=x%>, <%=this.x%>

<h1 align="center">JSP页面构成</h1>
<%=getHello("朋友")%> ,
现在是，<%=now %>
<br>
<jsp:include flush="false" page="a.html">
    <jsp:param name="str" value="参数"/>
</jsp:include>
</body>
</html>

<%!
    String getHello1(String name) {
        return "Hi," + name + "!";
    }
%>