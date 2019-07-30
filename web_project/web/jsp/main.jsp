<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/holiday5.jpg");
        }
    </style>
</head>
<body>
<p>holan</p>
<img src="${pageContext.request.contextPath}/images/dora.jpg" height="150"/>
<form name="loginForm" method="post" action="controller">
    <br/><input type="submit" name="command" value="isLogin"/>
</form>
<form name="loginForm" method="post" action="controller">
    <br/><input type="submit" name="command" value="isSignUp"/>
</form>
</body>
</html>
