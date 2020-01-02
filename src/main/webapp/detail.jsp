<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/5 0005
  Time: 下午 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/css.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<jsp:include page="top.jsp"/>
<div style="text-align: right;">首页&nbsp;>&nbsp;计算机&nbsp;>&nbsp;Java基础入门</div>
<div id="detail">
    <img src="images/logo.jpg" height="60" width="900"/>
    <table>
        <tr>
            <td><input type="hidden" value="${product.id}" /></td>
            <td rowspan="2" width="135">

                <img src="${pageContext.request.contextPath}/images/${product.imgurl}" width="125" height="211"/></td>
            <td height="30">
                <table>
                    <tr>
                        <td><img/>${product.name}</td>
                    </tr>
                    <tr>
                        <td>售价：￥${product.price}</td>
                    </tr>
                    <tr>
                        <td>类别：${product.category}</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>内容简介：<br/>${product.description}
            </td>
        </tr>
    </table>
    <input type="button" value="购买"/>
    <script>
        $(":button").click(function(){
            var v=${product.id};
           // var v=$(":hidden").val();//为什么取不到值
            alert(v);
            $.ajax({
                type:"post",
                url:"addCart",
                data:{"id":v},
                success:function(){
                    alert("ok");
                },error:function(){
                    alert("error")
                }
            });
        });
    </script>
</div>
<jsp:include page="bottom.jsp"/>

</body>
</html>
