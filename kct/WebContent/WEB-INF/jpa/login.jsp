<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h3>欢迎使用舰娘工具，请登录</h3>
<form action="login" method="post">
    <table style="text-align: center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="u_name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="u_pass"></td>
        </tr>
        <tr><td colspan="2"><button>登陆</button></td></tr>
    </table>
</form>
<a href="register">没有账号？点此注册</a>
</body>
</html>
