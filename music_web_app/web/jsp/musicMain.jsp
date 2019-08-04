<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
<head>
    <title>Music Maid</title>
    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/images/wallpaper14.jpeg");
            background-repeat: no-repeat;
            background-size: cover;
        }
        .heart {
            background-color: red;
            height: 30px;
            transform: rotate(-45deg);
            width: 30px;
        }
        .heart:before,
        .heart:after {
            content: "";
            background-color: red;
            border-radius: 50%;
            height: 30px;
            position: absolute;
            width: 30px;
        }
        .heart:before {
            top: -15px;
            left: 0;
        }
    </style>
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <a href="controller?command=return">Return to main page</a>
    <a href="controller?command=mysongs">My songs</a>
    <a href="controller?command=logout">Log out</a>
</c:if>
<a href="controller?command=musicgenres">Music by genres</a>
<c:if test="${sessionScope.user == null}">
    <a href="controller?command=logout">main page</a>
</c:if>


<div>
    <h3>All songs</h3>
<table>
    <tr>
    <th></th>
    <th>Song Name</th>
    <th>Artist</th>
    </tr>
    <c:forEach var = "i" begin = "0" end = "${songs.size()-1}">
    <tr>
        <td>
            <c:out value="${songs.get(i).getId()}." />
        </td>
        <td><c:if test="${sessionScope.user != null}">
            <c:choose>
                <c:when test="${!existenceList.get(i)}">
                    <form name="loginForm" method="post" action="controller">
                        <input type="hidden" name="page" value="/jsp/musicMain.jsp"/>
                        <input type="hidden" name="command" value="addsong"/>
                        <input type="submit" name="add" value="add" />
                        <input type="hidden" name="id" value="${songs.get(i).getId()}" />
                        <input type="hidden" name="increment" value="${i}" />
                    </form>
                </c:when>
                <c:otherwise>
                    <form name="loginForm" method="post" action="controller">
                        <input type="hidden" name="page" value="/jsp/musicMain.jsp"/>
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
</div>

<div>
    <c:forEach var = "i" begin = "0" end = "${songs.size()-1}">
    Item <c:out value = "${songs.get(i).getName()}"/>
    </c:forEach>
</div>
<div>
    <h3>Latest released songs</h3>
    <table>
        <tr>
            <th></th>
            <th>Song Name</th>
            <th>Artist</th>
            <th>Released Date</th>
        </tr>
        <c:forEach var="song" items="${latestSongs}">
            <tr>
                <td>
                    <c:out value="${song.getId()}." />
                </td>
                <td>
                    <form name="loginForm" method="post" action="controller">
                        <c:if test="${sessionScope.user != null}">
                            <input type="hidden" name="command" value="addsong"/>
                            <input id="add" type="submit" name="add" value="add" />
                            <input type="hidden" name="id" value="${song.getId()}" />
                        </c:if>
                        <c:out value="${song.getName()}" />
                    </form>
                </td>
                <td>
                    <em><c:out value="${song.getSinger()}" /></em>
                </td>
                <td>
                    <em><c:out value="${song.getReleaseDate()}" /></em>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript">
    window.onload = function () {
        document.onkeydown = function (e) {
            return (e.which || e.keyCode) != 116;
        };
    }
</script>
</body>
</html>
