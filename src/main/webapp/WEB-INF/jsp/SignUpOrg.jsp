<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<jsp:include page="Header.jsp" />

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/signup_form.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    <title>Sign up</title>
</head>
<body>

<h1>ORGANIZATION</h1>
<p>Here could be some user information</p>

<sf:form method="POST" modelAttribute="user" action="/org" enctype="multipart/form-data">
    <table>
        <tr>
            <td> Name: </td>
            <td> <sf:input path="name" type="text" placeholder="Gimme Your name"/> </td>
        </tr>
        <tr>
            <td> Phone: </td>
            <td> <sf:input path="phone" type="number" placeholder="Gimme number ;D"/> </td>
        </tr>

        <tr>
            <td> Email: </td>
            <td> <sf:input path="email" type="email" placeholder="Gimme Your Electronic mail"/> </td>
        </tr>
        <tr>
            <td> Password: </td>
            <td> <sf:input path="password" type="password" placeholder="Gimme Your password"/> </td>
        </tr>
        <tr>
            <td> <sf:radiobutton path="Orgi" name="orginization" value="false" label="Volunteer"/> </td>
            <td> <sf:radiobutton path="Orgi" name="orginization" value="true" label="Orginization"/> </td>
        </tr>
        <tr>
            <td>
                <p class="imgbutton">
                    <sf:label for="image" path="image" style="cursor: pointer;">Upload your ugly mug here</sf:label>
                </p>
            </td>
            <td>
                <p>
                    <sf:input path="image" type="file" id="image" accept="image/*" name="image" onchange="loadFile(event)" style="display: none;" multiple="multiple" />
                </p>
                <p><img path="output" id="output" width="200"></p>
            </td>
        </tr>

    </table>

    <c:if test="${not empty error}">
        <div class="error">
                ${error}
        </div>
    </c:if>

    <input type="submit" VALUE="Become Human"/>

</sf:form>

</body>
<jsp:include page="Footer.jsp" />
</html>