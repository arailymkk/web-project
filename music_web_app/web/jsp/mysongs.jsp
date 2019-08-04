<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
<head>
    <title>new page</title>
</head>
<body>
${user}
<a href="controller?command=return">Return to main page</a>
<a href="controller?command=musicgenres">Music by genres</a>
<form name="loginForm" action="controller" method="post">
    <input type="hidden" name="command" value="musicMain"/>
    <input type="submit" value="music"/>
</form>
<c:set var="numberOfRows" value="0"/>
<table>
<c:forEach var="song" items="${favoriteSongs}">
    <tr>
        <td>
            <c:set var="numberOfRows" value="${numberOfRows+1}"/>
            <c:out value="${numberOfRows}."/>
        </td>
        <td>
            <input type="hidden" name="id" value="${song.getId()}" />
            <c:out value="${song.getName()}" />
        </td>
        <td>
            <em><c:out value="${song.getSinger()}" /></em>
        </td>
    </tr>
</c:forEach>
</table>
<p>My Playlist</p>
${favoriteSongs}
sisi
<a href="controller?command=logout">Log out</a>
</body>
</html>
