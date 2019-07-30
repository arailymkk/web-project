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
    <title>Welcome</title>
</head>
<body>
<a href="controller?command=return">Return to main page</a>
<h3>Welcome to your page</h3>
<hr/>
${user}, hello!
${newUserNotification}
<a href="controller?command=logout">Log out</a>
</body>
</html>
