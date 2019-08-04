<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<c:set var="language" value="${sessionScope.lang}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locales"/>


<html language="${language}">
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <title>Main</title>

    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/wallpaper14.jpeg");
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>

<body>
<div style="background-color:black;color:white;padding:20px;">
    <ul>
        <li><a href="?locale=en"><fmt:message key="label.lang.en"/></a></li>
        <li><a href="?locale=de"><fmt:message key="label.lang.de" /></a></li>
        <li><a href="?locale=ru"><fmt:message key="label.lang.ru" /></a></li>
    </ul>
</div>
<p><fmt:message key="label.login"/></p>
<br/>
<p>holan</p>
<img src="${pageContext.request.contextPath}/images/dora.jpg" height="150"/>

<form name="loginForm" action="controller" method="post">
    <input type="hidden" name="command" value="musicMain"/>
    <input type="submit" value="music">
</form>

<form name="loginForm" method="post" action="controller">
    <br/><input type="submit" name="command" value="isLogin"/>
</form>

<form name="loginForm" method="post" action="controller">
    <br/><input type="submit" name="command" value="isSignUp"/>
</form>
<a href="controller?command=musicgenres">Music by genres</a>

</body>
</html>
