<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19 0019
  Time: 上午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload=function(){
            document.getElementsByTagName("a")[0].onclick=function(){
                var request=false;
                if(window.XMLHttpRequest){
                    request=new XMLHttpRequest();
                }else if(window.ActiveXObject){
                    request=new ActiveXObject("Microsoft.XMLHTTP");
                }
                if(request){
                    request.open("get","a.txt",true);
                    request.onreadystatechange=function(){
                        if(request.readyState==4){
                            if(request.status==200){
                                document.write(request.responseText);
                            }
                        }
                    };
                    request.send();
                }
            };
        };
    </script>
</head>
<body>
<a href="javascript:;">Hello Ajax</a>
</body>
</html>
