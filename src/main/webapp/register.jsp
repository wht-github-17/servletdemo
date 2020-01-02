<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/2 0002
  Time: 上午 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="css/css.css" rel="stylesheet"/>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="register">
    <fieldset>
        <h1>新用户注册</h1>
        <form action="register" method="post">
            <table>
                <tr>
                    <td>邮箱：</td>
                    <td><input name="email"/></td>
                    <td>请输入有效的邮箱地址</td>
                </tr>
                <tr>
                    <td>用户名：</td>
                    <td><input name="username"/></td>
                    <td>字母数字下划线1到10位，不能是数字开头</td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"/></td>
                    <td>密码请设置6－16位字符</td>
                </tr>
                <tr>
                    <td>重复密码：</td>
                    <td><input type="password"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input type="radio" checked name="gender"/>男<input type="radio" name="gender"/>女</td>
                    <td></td>
                </tr>
                <tr>
                    <td>联系电话：</td>
                    <td colspan="2"><input name="phone"/></td>

                </tr>
                <tr>
                    <td>个人介绍：</td>
                    <td colspan="2"><textarea rows="10" cols="40" name="introduce"></textarea></td>

                </tr>
            </table>
           <h1>注册验证</h1>
            <table>
                <tr>
                    <td>输入验证码：</td>
                    <td><input name="validatecode"/></td>
                </tr>
                <tr>
                    <td><img id="validateCode" src="validateCode"/></td>
                    <td><a href="javascript:" >看不清换一张</a></td>
                    <script>
                        $("a").click(function(){
                            $("#validateCode").get(0).src='validateCode?'+Math.random();
                        });
                    </script>
                </tr>

            </table>
            <br/>
            <br/>
            <input type="submit" value="同意并提交"/>
        </form>
    </fieldset>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>
