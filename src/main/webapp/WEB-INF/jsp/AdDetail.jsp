<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
       <%-- <title>"${ad.name}"</title> --%>
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
        <a href="/ad/${id}/apply"> apply </a>
        <c:choose>
            <c:when test="${not empty applicants}">
                <c:forEach var="applicant_list" items="${applicants}">
                    <p>${applicant_list.work}<p>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h3>No volunteers have applied</h3>
            </c:otherwise>
        </c:choose>
        <div>
        <a href="/"> E.T. go home </a>
        </div>
    </body>
</html>
