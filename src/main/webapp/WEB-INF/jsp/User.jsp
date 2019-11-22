<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/user.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
        <jsp:include page="Header.jsp" />

        <title>Account</title>
    </head>
    <body>
    <main>
        <div class="row">
                <div class="user_img">
                    <img src="${pageContext.request.contextPath}/resources/images/${user.imageName}" class="img">
                    <h3 class="user_title">Welcome, ${user.name}</h3>
                </div>
            <div class="banner">
                <h3>Personal details</h3>
            </div>
            <div class="user_info">
                <div class="col">
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
                </div>
                <div class="col"></div>
                <div class="col">
                    <div class="edit">
                        <div class="edit_btn">
                            <a href="/" class="btn">Edit</a>
                        </div>
                    </div>
                </div>
            </div>
                <c:choose>
                    <c:when test="${not empty jobs}">
                        <div class="banner">
                            <h3>List of applications</h3>
                        </div>
                        <div class="list">
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
                        <div class="banner">
                            <h3>List of ads</h3>
                        </div>
                    <div class="list">
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
            <div class="logout_btn">
                <a href="/logout" class="btn">Log out</a>
            </div>
            </div>
    </main>
    </body>
<jsp:include page="Footer.jsp" />
</html>