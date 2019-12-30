<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<html lang="en">

<jsp:include page="Header.jsp" />

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/organizations.css"/>"/>
    <title>Organizations</title>
</head>
<body>
<main>
    <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
    <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
    <h2 class="advert">THE ORGANIZATIONS</h2>
    <%-- Leitargluggi sem leitar í auglýsingalista eftir leitarorðum--%>

    <c:choose>
    <c:when test="${not empty organization_list}">
    <div class="advertlist">
        <div class="list">
            <c:forEach var="organization" items="${organization_list}">
                    <div class="organization">
                        <a href="/user/${organization.id}">
                            <div class="owner_img">
                                <img class="img" src="${pageContext.request.contextPath}/resources/images/${organization.imageName}"/>
                            </div>
                            <h4>${organization.name}</h4>
                        </a>
                    </div>
            </c:forEach>
        </div>
        </c:when>
            <%--If all tests are false, then do this--%>
        <c:otherwise>
        <h3>No organizations</h3>
        </c:otherwise>
        </c:choose>
</main>
</body>
</html>
