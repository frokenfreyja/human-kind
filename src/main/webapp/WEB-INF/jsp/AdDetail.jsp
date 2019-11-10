<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <main>
        <div class="ad_content">
            <div class="ad_img"><img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" /></div>
            <div class="row">
                <h2 class="ad_title">${ad.name}</h2>
                <div class="ad_owner">
                    <a href="/">
                        <div class="owner_img">
                            <img class="img" src="${pageContext.request.contextPath}/resources/images/${owner.imageName}"/>
                        </div>
                ${owner.name}
                    </a>
                </div>
            </div>
            <p class="ad_date">Date: <fmt:formatDate type="both" value="${ad.date}"/></p>
            <p class="ad_duration">Duration: ${ad.duration}</p>
            <p class="ad_location">Location: ${ad.location}</p>
            <p class="ad_zip">Zip: ${ad.zipcode}</p>
            <p class="ad_description">${ad.description}</p>
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
        </div>
        </div>
    </main>
    </body>
</html>
