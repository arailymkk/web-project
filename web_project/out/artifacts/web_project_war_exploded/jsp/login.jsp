<%--
  Created by IntelliJ IDEA.
  User: arailymkaiyrova
  Date: 2019-07-26
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="post" action="controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""/><br/>
    Password:<br/>
    <input type="password" name="password" value=""/><br/>
    ${errorLoginPassMessage}
    ${wrongAction}
    ${nullPage}
    <br/><input type="submit" value="Log in"/>
</form>
</body>
</html>
