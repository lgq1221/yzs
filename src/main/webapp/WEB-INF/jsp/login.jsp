<%--
  Created by IntelliJ IDEA.
  User: Lgq
  Date: 2019/1/14
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>登陆</title>
    </head>
    <body>
        <form method="get" action="/user/login">
            用户名：<input type="text" name="name"/><br/>
            密码：  <input type="text" name="password"/>
            <input type="submit" value="登陆">
        </form>
    </body>
</html>
