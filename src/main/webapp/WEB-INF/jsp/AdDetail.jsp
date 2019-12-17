<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="Header.jsp" />

<html lang="en">

    <head>
           <title>${ad.name}</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/ad_detail.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/grid.css"/>"/>
    </head>

    <body>
    <main>
        <div class="row">
            <div class="ad_img"><img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" /></div>
            <div class="first_row">
                <div class="ad_info">
                    <h2 class="ad_title">${ad.name}</h2>
                    <p>${genLoc}</p>
                </div>
                <div class="ad_owner">
                    <a href="/user/${ad.owner}">
                        <div class="owner_img">
                            <img class="img" src="${pageContext.request.contextPath}/resources/images/${owner.imageName}"/>
                        </div>
                ${owner.name}
                    </a>
                </div>
            </div>
            <div class="info_section">
                <p class="info_section_title">Date and time</p>
                <fmt:formatDate type="both" value="${ad.date}"/>
            </div>
            <div class="info_section">
                <p class="info_section_title">Location</p>
                <p>${ad.location}</p>
            </div>
            <div class="info_section">
                <p class="info_section_title">Zip</p>
                <p>${ad.zipcode}</p>
            </div>
            <div class="info_section">
                <p class="info_section_title">Description</p>
                <p>${ad.description}</p>
            </div>

                <c:if test="${not empty currUser && not currUser.orgi && not alreadyApplied}">
                    <div class="apply_btn">
                        <a href="/ad/${id}/apply" class="btn">Apply</a>
                    </div>
                </c:if>
                <c:if test="${not empty currUser && not currUser.orgi && alreadyApplied}">
                    <div class="apply_btn">
                        <a href="/ad/${id}/unapply" class="btn">Unapply</a>
                    </div>
                </c:if>
            <c:choose>
                <c:when test="${not empty applicants}">
                <div class="info_section">
                    <p class="info_section_title">List of applicants</p>
                        <c:forEach var="applicant_list" items="${applicants}" varStatus="status">
                            <p class="applicants">
                                <a href="/user/${applicant_list.id}">
                                        ${status.index+1}. ${applicant_list.name}
                                </a>
                        </c:forEach>
                </div>
                </c:when>
            </c:choose>
            <c:if test="${currUser.orgi && currUser eq owner}">
                <div class="apply_btn">
                    <a href="/ad/${id}/delete" class="btn">Remove</a>
                </div>
            </c:if>
            <div>
        </div>
        </div>
    </main>
    </body>
</html>
