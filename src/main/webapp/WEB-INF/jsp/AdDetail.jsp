<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="Header.jsp" />
<jsp:include page="Footer.jsp" />

<html lang="en">

    <head>
           <title>${ad.name}</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/ad_detail.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/grid.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    </head>

    <body>
        <p>Name: "${ad.name}"</p>
        <p>Image:<img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" />
        <p>Owner: "${owner.name}"</p>
        <p>Date: "${ad.date}"</p>
        <p>Duration: "${ad.duration}"</p>
        <p>Location: "${ad.location}"</p>
        <p>Zip: "${ad.zipcode}"</p>
        <p>Description: "${ad.description}"</p>
        <p>Payout:</p>
        <c:if test="${not empty currUser && not currUser.orgi}">
            <a href="/ad/${id}/apply"> Apply </a>
        </c:if>
        <c:choose>
            <c:when test="${not empty applicants}">
                <c:forEach var="applicant_list" items="${applicants}">
                    <p><a href="/user">${applicant_list.name}</a><p>
                </c:forEach>
            </c:when>
        </c:choose>
        <div>
        <a href="/"> E.T. go home </a>
        </div>
    </body>
</html>
