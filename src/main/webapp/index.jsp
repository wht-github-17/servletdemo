<%@page contentType="text/html;UTF-8" language="java"%>
<%@ page import="com.wht.domain.Notice" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <link href="css/css.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script src="js/jquery-3.2.1.min.js">
    </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="notice">
    <img src="images/notice.jpg" width="65" height="65"/>
    <span>
        <%
            List<Notice> notices=(List)request.getAttribute("notices");
            Notice notice=notices.get(0);

        %>
        <%=notice.getDetails()%>
        <%=notice.getnTime()%>
    </span>
</div>
<div id="sale">
    <img src="images/sale.jpg" width=65" height="65"/>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>
