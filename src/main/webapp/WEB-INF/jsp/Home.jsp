<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<jsp:include page="Header.jsp" />

<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/grid.css"/>"/>
        <title>Human-Kind</title>
    </head>
    <body>

    <div class="container">
    <div class="section1">
        <div class="section1_content">
            <div class="title">
                <h1>HUMAN - KIND</h1>
            </div>
            <div class="subtitle">
                <p>Be kind, be human.</p>
            </div>
            <div>
                <c:choose>
                    <c:when test="${empty currentUser}">
                        <a href="/login" class="login_btn">LOG IN</a>
                    </c:when>
                    <c:when test="${currentUserOrgi}">
                        <a href="/new_ad" class="login_btn">POST AD</a>
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <div class="section3">
        <div class="section3_content">
            <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
            <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
                <h2 class="advert">AVAILABLE JOBS</h2>
                <c:choose>
                    <c:when test="${not empty ad_list}">
                        <div class="advertlist">
                            <div class="list">
                                <c:forEach begin="0" end="9" var="ad" items="${ad_list}">
                                    <div class="ad">
                                        <a href="/ad/${ad.id}">
                                            <div class="img"><img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" /></div>
                                                ${fn:substring(ad.date, 0,10)}
                                            <div class="card_title">
                                                    ${ad.name}
                                            </div>
                                        </a>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div>
                            <a href="/all_ads" class="ads_btn">VIEW ALL</a>
                        </div>
                    </c:when>
                    <%--If all tests are false, then do this--%>
                    <c:otherwise>
                        <h3>No available job ads</h3>
                    </c:otherwise>
                </c:choose>
            </div>
    </div>
    </div>
    </body>
</html>
