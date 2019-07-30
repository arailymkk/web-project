<%--
  Created by IntelliJ IDEA.
  User: arailymkaiyrova
  Date: 2019-07-26
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    Request from ${pageContext.errorData.requestURI} is failed <br/>
    Servlet name ot type: ${pageContext.errorData.servletName} <br/>
    Status code: ${pageContext.errorData.statusCode} <br/>
    Exception: ${pageContext.errorData.throwable} <br/>
</body>
</html>
