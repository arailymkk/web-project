<%--
  Created by IntelliJ IDEA.
  User: arailymkaiyrova
  Date: 2019-07-29
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>
<a href="controller?command=return">Return to main page</a>
<h4><em>Please type information about yourself below</em></h4>
<form name="loginForm" method="post" action="controller">
    <input type="hidden" name="command" value="signup"/>
    Login:<br/>
    <input type="text" name="login" value=""/><br/>
    Password:<br/>
    <input type="password" name="password" value=""/><br/>
    <br/><input type="submit" value="Sign up"/>
    ${errorSignupPassMessage}
</form>
</body>
</html>
