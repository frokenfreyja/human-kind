<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html lang="en">
<jsp:include page="Header.jsp" />


    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/user.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
        <title>Account</title>
    </head>
    <body>
    <main>
        <div class="row">
            <div class="col">
                <div class="user_img">
                    <img src="${pageContext.request.contextPath}/resources/images/${user.imageName}" class="img">
                </div>
            <div class="user_info">
                <h2>${user.name}</h2>

                <div class="row_info">
                    <img src="${pageContext.request.contextPath}/resources/images/email.png" class="icon"/>
                    <p>${user.email}</p>
                </div>
                <div class="row_info">
                    <img src="${pageContext.request.contextPath}/resources/images/phone.png" class="icon"/>
                    <p>${user.phone}</p>
                </div>
                <div class="row_info">
                    <img src="${pageContext.request.contextPath}/resources/images/calendar.png" class="icon"/>
                    <p>${fn:substring(user.birthDate, 0, 10)}</p>
                </div>

                <div class="row_info">
                    <p>Bio: ${user.bio}</p>
                </div>
                <div class="edit_btn">
                    <a href="/" class="btn">Edit</a>
                </div>
                <div class="logout_btn">
                    <a href="/logout" class="btn">Log out</a>
                </div>
            </div>
            </div>
            <div class="col">
                <c:choose>
                    <c:when test="${not empty jobs}">
                        <div class="list">
                            <p class="info_title">List of applications</p>
                            <c:forEach var="job" items="${jobs}" varStatus="status">
                                <p class="list_items">
                                    <a href="/ad/${job.id}">
                                            ${status.index+1}. ${job.name}
                                    </a>
                                </p>
                            </c:forEach>
                        </div>
                    </c:when>
                </c:choose>

                <c:choose>
                    <c:when test="${not empty own_ads}">
                    <div class="list">
                    <p class="info_title">List of ads</p>
                         <c:forEach var="job" items="${own_ads}" varStatus="status">
                            <p class="list_items">
                                <a href="/ad/${job.id}">
                                    ${status.index+1}. ${job.name}
                                </a>
                            </p>
                        </c:forEach>
                    </div>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </main>
    </body>
<jsp:include page="Footer.jsp" />
</html>