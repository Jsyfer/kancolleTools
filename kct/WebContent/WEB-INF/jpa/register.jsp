<%--
  Created by IntelliJ IDEA.
  User: Golde
  Date: 2019/12/15
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<h3>注册新账号</h3>
<form action="register" method="post">
    <table style="text-align: center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="u_name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="u_pass"></td>
        </tr>
        <tr>
            <td>再次输入密码：</td>
            <td><input type="password" name="u_pass_confirm"></td>
        </tr>
        <tr><td colspan="2"><button>注册</button></td></tr>
    </table>
</form>
<a href="login">已有账号？点此登陆</a>
</body>
</html>
