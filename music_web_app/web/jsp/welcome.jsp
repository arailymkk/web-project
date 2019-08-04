<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<a href="controller?command=musicgenres">Music by genres</a>
<form name="loginForm" action="controller" method="post">
    <input type="hidden" name="command" value="musicMain"/>
    <input type="submit" value="music"/>
</form>
<a href="controller?command=mysongs">My songs</a>
<h3>Welcome to your page</h3>
<hr/>
${user}, hello!
${newUserNotification}
<a href="controller?command=logout">Log out</a>
</body>
</html>
