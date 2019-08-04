<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>
<a href="controller?command=return">Return to main page</a>
<h4><em>Please type information about yourself below</em></h4>
<form name="loginForm" method="post" action="controller">
    <input type="hidden" name="command" value="signup"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname" value=""/></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login" value=""/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td>
                day<input type="number" name="day" value="" maxlength="2" max="31" min="1"/>
                month<input type="number" name="month" value="" maxlength="2" max="12" min="1"/>
                year<input type="number" name="year" value="" maxlength="4" min="1900" max="2019"/>
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="gender" value="F">Female</input>
                <input type="radio" name="gender" value="M">Male</input>
            </td>
        </tr>
    </table>
    <br/><input type="submit" value="Sign up"/>
    ${errorSignupPassMessage}
</form>
</body>
</html>
