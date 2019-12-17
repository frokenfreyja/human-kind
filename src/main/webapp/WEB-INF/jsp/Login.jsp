<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
        <jsp:include page="Header.jsp" />

        <title>Log in</title>
    </head>
    <body>
    <main>
        <div class="row">
            <h1 class="title">LOG IN</h1>
            <sf:form method="POST" modelAttribute="user" action="/login">
                <div class="login_table">
                    <div class="input">
                        <img src="${pageContext.request.contextPath}/resources/images/email.png" class="img"/>
                        <sf:input path="email" type="email" placeholder="Email Address" class="login_text" />
                    </div>

                    <div class="input">
                        <img src="${pageContext.request.contextPath}/resources/images/lock.png" class="img"/>
                        <sf:input path="password" type="password" placeholder="Password" class="login_text"/>
                    </div>
                </div>

                <c:if test="${not empty loginDenied}">
                    <div class="error">
                            ${loginDenied}
                    </div>
                </c:if>

                <div class="login_btn">
                    <input class="btn" type="submit" VALUE="LOG IN"/>
                </div>
            </sf:form>
            <div class="newaccount">
                <p>Don't have an account yet? <br/> No problem!</p>
                <a href="/signup" class="signup_btn">CREATE ACCOUNT</a>
            </div>
        </div>
    </main>
    </body>

</html>