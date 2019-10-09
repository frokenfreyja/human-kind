<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Sign up</title>
</head>
<body>

    <h1>Sign up</h1>
    <p>Here could be some user information</p>

    <sf:form method="POST" modelAttribute="user" action="/signup" enctype="multipart/form-data">
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

        <input type="submit" VALUE="Become Human"/>

    </sf:form>

</body>

</html>