<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
<head>
    <title>Hip Hop Music</title>
</head>
<body >

<div>
    <c:if test="${sessionScope.user != null}">
        <a href="controller?command=return">Return to main page</a>
        <a href="controller?command=mysongs">My songs</a>
        <a href="controller?command=logout">Log out</a>
    </c:if>
    <a href="controller?command=musicmain">All the songs</a>
    <c:if test="${sessionScope.user == null}">
        <a href="controller?command=logout">main page</a>
    </c:if>
</div>

<c:set var="numberOfRows" value="0"/>
<table>
    <c:forEach var = "i" begin = "0" end = "${songs.size()-1}">
        <tr>
            <td>
                <c:set var="numberOfRows" value="${numberOfRows+1}"/>
                <c:out value="${numberOfRows}."/>
            </td>
            <td><c:if test="${sessionScope.user != null}">
                <c:choose>
                    <c:when test="${!existenceList.get(i)}">
                        <form name="loginForm" method="post" action="controller">
                            <input type="hidden" name="page" value="/jsp/hiphop.jsp"/>
                            <input type="hidden" name="command" value="addsong"/>
                            <input id="add" type="submit" name="add" value="add" />
                            <input type="hidden" name="id" value="${songs.get(i).getId()}" />
                            <input type="hidden" name="increment" value="${i}" />
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form name="loginForm" method="post" action="controller">
                            <input type="hidden" name="page" value="/jsp/hiphop.jsp"/>
                            <input type="hidden" name="command" value="removesong"/>
                            <input type="submit" name="remove" value="remove" />
                            <input type="hidden" name="id" value="${songs.get(i).getId()}" />
                            <input type="hidden" name="increment" value="${i}" />
                        </form>
                    </c:otherwise>
                </c:choose>
            </c:if>
            </td>
            <td>
                <c:out value="${songs.get(i).getName()}" />
            </td>
            <td>
                <em><c:out value="${songs.get(i).getSinger()}" /></em>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
