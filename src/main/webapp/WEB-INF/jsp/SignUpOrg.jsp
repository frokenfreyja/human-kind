<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<jsp:include page="Header.jsp"/>

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/signup_form.css"/>"/>
    <script>
        var loadFile = function (event) {
            var image = document.getElementById('output');
            image.src = URL.createObjectURL(event.target.files[0]);
        }
    </script>
    <title>Sign up</title>
</head>
<body>
<main>
    <div class="row">
        <h1 class="title">ORGANIZATION</h1>
        <sf:form method="POST" modelAttribute="user" action="/org" enctype="multipart/form-data" class="form">
            <div class="input">
                <img src="${pageContext.request.contextPath}/resources/images/name.png" class="img"/>
                <sf:input path="name" type="text" placeholder="Full name" class="signup_text" required="required"/>
            </div>

            <div class="input">
                <img src="${pageContext.request.contextPath}/resources/images/email.png" class="img"/>
                <sf:input path="email" type="email" placeholder="Email" class="signup_text" required="required"/>
            </div>

            <div class="input">
                <img src="${pageContext.request.contextPath}/resources/images/phone.png" class="img"/>
                <sf:input path="phone" type="number" placeholder="Phone number" class="signup_text"
                          required="required"/>
            </div>

            <div class="input">
                <img src="${pageContext.request.contextPath}/resources/images/lock2.png" class="img"/>
                <sf:input path="password" type="password" placeholder="Password" class="signup_text"
                          required="required"/>
            </div>

            <div class="input">
                <img src="${pageContext.request.contextPath}/resources/images/lock2.png" class="img"/>
                <sf:input path="confirmPassword" type="password" placeholder="Confirm password" class="signup_text"
                          required="required"/>
            </div>

            <c:if test="${not empty error}">
                <div class="error">
                        ${error}
                </div>
            </c:if>

            <div class="account_img">
                <div class="imgbutton">
                    <sf:label for="image" path="image" style="cursor: pointer;">Upload photo
                        <div class="output">
                            <img path="output" id="output" class="user_img"
                                 src="${pageContext.request.contextPath}/resources/images/account.png">
                        </div>
                    </sf:label>
                </div>
                <sf:input path="image" type="file" id="image" accept="image/*" name="image" onchange="loadFile(event)"
                          style="display: none;" multiple="multiple"/>
            </div>

            <div class="signup_btn">
                <input class="btn" type="submit" VALUE="SIGN UP"/>
            </div>

        </sf:form>
    </div>
</main>
</body>
</html>