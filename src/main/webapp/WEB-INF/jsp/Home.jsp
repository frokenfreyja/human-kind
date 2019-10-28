<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="Header.jsp" />
<jsp:include page="Footer.jsp" />

<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
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
            <div>
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
                <h3 class="advert">AVAILABLE JOBS</h3>
                <c:choose>
                    <c:when test="${not empty work_list}">
                        <div class="advertlist">

                        <c:forEach begin="0" end="9" var="job_details" items="${work_list}">
                            <div class="all_ads">
                                <div class="ad">
                                    <div class="img"><img src="${pageContext.request.contextPath}/resources/images/${job_details.imageName}" /></div>
                                    <div class="name"><a href="/ad/${job_details.id}">${job_details.name}</a></div>
                                    <div class="date">${job_details.date}</div>
                                    <div class="cat">${job_details.interest}</div>
                                </div>
                            </div>
                        </c:forEach>
                        <div>
                            <a href="/all_ads" class="ads_btn">VIEW ALL</a>
                        </div>
                    </div>
                    </c:when>
                    <%--If all tests are false, then do this--%>
                    <c:otherwise>
                        <h3>No available job ads</h3>
                    </c:otherwise>
                </c:choose>
            </div>

    </body>
</html>
