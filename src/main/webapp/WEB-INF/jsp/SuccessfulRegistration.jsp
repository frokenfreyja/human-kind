<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<head>
    <title>Registration Success</title>
</head>
<body>
<center>
    <h3>A verification email has been sent to: ${email}</h3>
    <p>${message}</p>
</center>
</body>
</html>