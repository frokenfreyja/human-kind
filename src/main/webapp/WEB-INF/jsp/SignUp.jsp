<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<jsp:include page="Header.jsp" />

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/signup.css"/>"/>
    <title>Sign up</title>
</head>
<body>
<main>
    <div class="orgOrVol">
        <p class="question">Which one are you?</p>
        <div class="buttons">
            <a href="/org" class="signup_btn">ORGANIZATION</a>
            <a href="/vol" class="signup_btn">VOLUNTEER</a>
        </div>
    </div>
</main>
</body>
</html>