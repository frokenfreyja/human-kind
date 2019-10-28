<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<html class="grid" lang="en">
<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/newad.css"/>"/>
    <title>New ad</title>
    <script>
        var loadFile = function(event) {
            var image = document.getElementById('output');
            image.src = URL.createObjectURL(event.target.files[0]);
        }
    </script>
</head>
<body>
<main>
    <div class="row">
        <%-- Form til þess að skrá nýja auglýsingu--%>
        <h1 class="newadvert">CREATE JOB AD</h1>
            <sf:form method="POST" modelAttribute="work" action="/new_ad" enctype="multipart/form-data">
                <table class="newadvertise">
                    <tr>
                            <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                        <td>
                            <sf:input path="name" class="formbox" type="text" placeholder="Title" required="required" autofocus="autofocus"/>
                        </td>
                    </tr>
                    <tr>
                            <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                        <td>
                            <sf:input path="description" class="formbox" type="text" placeholder="Description" required="required" />
                        </td>
                    </tr>
                    <tr>
                            <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                        <td>
                            <sf:input path="date" class="formbox" type="text" placeholder="DD-MM-YYYY" required="required" />
                        </td>
                    </tr>
                </table>
                <input type="submit" class="formbutton" value="NEXT" />
            </sf:form>
        </div>
</main>

<footer class="footer">
    <div class="footer_content">
        <a class="footer__link" href="/facebook"><img src="/resources/images/facebook.svg" class="footer_icon"/></a>
        <a class="footer__link" href="/instagram"><img src="/resources/images/instagram.png" class="footer_icon"/></a>
        <a class="footer__link" href="/twitter"><img src="/resources/images/twitter.png" class="footer_icon"/></a>
        <a class="footer__link" href="/email"><img src="/resources/images/mailbox.png" class="footer_icon"/></a>
    </div>
</footer>
</body>
</html>