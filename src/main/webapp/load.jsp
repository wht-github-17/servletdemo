<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19 0019
  Time: 上午 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        $(document).ready(function () {
            $(":radio").click(function(){
                $("#box").html(decodeURIComponent($(this).serializeArray()[0].value));
            });
            $(":button[name=btn1]").click(function () {
var v=$(":text").val();
alert(v);
//load方法
                // $("#box").load("test.jsp", {"name":v}, function (response, status, xhr) {
                //     alert(response);
                //     $("#box").text(response+"123");
                //     if (status == 'success') {
                //         alert('成功后的处理');
                //         alert(xhr.responseText);
                //         alert(xhr.responseXML);
                //         alert(xhr.status);
                //         alert(xhr.statusText);
                //     }
                //
                //
                // });
                //get方法
                // $.get("test.jsp",{"name":v},function(response,status,xhr){
                //     $("#box").html(xhr.responseText);
                // },"html");
                //post方法
                // $.post("test.jsp",{name:v},function(response,status,xhr){
                //     alert(xhr.responseText);
                // },"text");
                //ajax方法
                $.ajax({
                    type:post,
                    url:"test.jsp",
                    data:{name:v},
                    dataType:'text',
                    success:function(data){
                        $("#box").html(data);
                    },
                    error:function(){
                        alert("error");
                    }
                });
            });
            $(":button[name=btn2]").click(function(){
                $.getScript("${pageContext.request.contextPath}/js/my.js");
            });
            $(":button[name=btn3]").click(function(){
                $.getJSON("data.json",function(response,status,xhr){
                    $("#box").html(response.title+":"+response.num);
                });
            });
        })
        ;
    </script>
</head>
<body>
<input name="name"/><input name="btn1" type="button" value="ajax获取"/>
<div id="box"></div>
<input name="btn2" type="button" value="加载js"/>
<input name="btn3" type="button" value="加载json"/>
<input type="radio" value="男" name="gender"/>
<input type="radio" value="女" name="gender"/>
</body>
</html>
