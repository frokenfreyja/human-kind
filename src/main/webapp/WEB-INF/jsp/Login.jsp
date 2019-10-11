<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Login page</title>
    </head>
    <body>

    <h1>Login Page</h1>

    <c:if test="${not empty loginDenied}">
        ${loginDenied}
        <audio autoplay>
            <source src="/resources/sounds/doorlocked_buzz1.wav" type="audio/wav">
        </audio>
    </c:if>
    <sf:form method="POST" modelAttribute="user" action="/login">
        <table>
            <tr>
                <td> Email: </td>
                <td> <sf:input path="email" type="email" placeholder="Gimme Your Electronic mail"/> </td>
            </tr>
            <tr>
                <td> Password: </td>
                <td> <sf:input path="password" type="password" placeholder="Gimme Your Secret >:3"/> </td>
            </tr>
        </table>

        <input type="submit" VALUE="login"/>
    |
    </sf:form>
    </body>

</html>