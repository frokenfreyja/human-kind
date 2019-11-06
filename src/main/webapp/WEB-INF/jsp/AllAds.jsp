<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<jsp:include page="Header.jsp" />

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/all_ads.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    <title>Ads</title>
</head>
<body>
<main>
    <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
    <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
    <h2 class="advert">AVAILABLE JOBS</h2>
    <div class="advertlist">
        <c:choose>
            <c:when test="${not empty work_list}">
                <c:forEach var="job_details" items="${work_list}">
                    <div class="all_ads">
                        <div class="ad">
                            <div class="img"><img src="${pageContext.request.contextPath}/resources/images/${job_details.imageName}" /></div>
                            <div class="name"><a href="/ad/${job_details.id}">${job_details.name}</a></div>
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
</main>
</body>
<jsp:include page="Footer.jsp" />
</html>
