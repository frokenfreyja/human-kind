<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>"/>
        <title>Human-Kind</title>
    </head>
    <body>

    <div class="section1">
        <div class="section1_content">
            <div class="title">
                <h1>HUMAN - KIND</h1>
            </div>
            <div class="subtitle">
                <p>Be kind, be human.</p>
            </div>
            <div class="section1_btn">
                <a href="/login" class="login_btn">SIGN IN</a>
            </div>
        </div>
    </div>

    <div class="divider"></div>

    <div class="section2">
        <p>HAKK</p>
    </div>

    <div class="divider"></div>

    <div class="section3">

            <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
            <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
                <p class="advert">AVAILABLE JOBS</p>
                <div class="advertlist">
                <c:choose>
                    <c:when test="${not empty work_list}">
                            <c:forEach var="job_details" items="${work_list}">
                                <div class="all_ads">
                                    <div class="ad">
                                        <div class="img"><img src="${pageContext.request.contextPath}/resources/images/${job_details.imageName}" /></div>
                                        <div class="name"><a href="/job_details/${job_details.id}">${job_details.name}</a></div>
                                        <div class="date">${job_details.date}</div>
                                        <div class="cat">${job_details.interest}</div>
                                    </div>
                                </div>
                            </c:forEach>
                    </c:when>
                    <%--If all tests are false, then do this--%>
                    <c:otherwise>
                        <h3>No available job ads</h3>
                    </c:otherwise>
                </c:choose>
            </div>
    </div>

    </body>
    <footer class="footer">
        <div class="footer_content">
            <a class="footer__link" href="/facebook"><img src="/resources/images/facebook.svg" class="footer_icon"/></a>
            <a class="footer__link" href="/instagram"><img src="/resources/images/instagram.png" class="footer_icon"/></a>
            <a class="footer__link" href="/twitter"><img src="/resources/images/twitter.png" class="footer_icon"/></a>
            <a class="footer__link" href="/email"><img src="/resources/images/mailbox.png" class="footer_icon"/></a>
        </div>
    </footer>
</html>
