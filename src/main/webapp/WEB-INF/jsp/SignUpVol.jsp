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
<main>
    <div class="row">
    <h1 class="title">VOLUNTEER</h1>
<p>Here could be some user information</p>

<sf:form method="POST" modelAttribute="user" action="/vol" enctype="multipart/form-data">
    <div class="signup_table">
        <div class="input">
            <img src="${pageContext.request.contextPath}/resources/images/email.png" class="img"/>
            <sf:input path="name" type="text" placeholder="Full name" class="signup_text"/>
        </div>

        <%--
        <div class="input">
            gender
        </div>
        --%>

        <div class="input">
            <sf:input path="email" type="email" placeholder="Email" class="signup_text"/>
        </div>

        <div class="input">
            <sf:input path="phone" type="number" placeholder="Phone number" class="signup_text"/>
        </div>

        <div class="input">
            <sf:input path="password" type="password" placeholder="Password" class="signup_text"/>
        </div>

        <%--
        <div class="input">
            date of birth
        </div>
        --%>

        <div class="account_img">
            <p class="imgbutton">
                <sf:label for="image" path="image" style="cursor: pointer;">Upload your ugly mug here</sf:label>
            </p>
            <p>
                <sf:input path="image" type="file" id="image" accept="image/*" name="image" onchange="loadFile(event)" style="display: none;" multiple="multiple" />
            </p>
            <p><img path="output" id="output" width="200"></p>
        </div>
    </div>

    <c:if test="${not empty error}">
        <div class="error">
                ${error}
        </div>
    </c:if>

        <div class="signup_btn">
            <input class="btn" type="submit" VALUE="REGISTER"/>
        </div>

</sf:form>
        </div>
</main>
</body>
<jsp:include page="Footer.jsp" />
</html>