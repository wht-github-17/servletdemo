<%@ page import="com.wht.domain.Notice" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/16 0016
  Time: 上午 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="notice" class="com.wht.domain.Notice" scope="request"/>
<jsp:setProperty name="notice" property="title" value="放假"/>
${notice.title}
<jsp:setProperty name="notice" property="title" param="title"/>
${notice["title"]}

<%
    String[] f = {"banana","apple","pear"};
    request.setAttribute("fruits",f);
 Cookie cookie=new Cookie("username","kitty");
 response.addCookie(cookie);
%>
aa${fruits[0]}aa
<br/>
${param.password}
${paramValues.hobby[0]}
${header.host}
${cookie.username.value}
${pageContext.request.method}

<jsp:include page="bottom.jsp"/>
</body>
</html>
