<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<html lang="en">

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/user.css"/>"/>
    <jsp:include page="Header.jsp"/>

    <title>Account</title>
</head>
<body>
<main>
    <div class="row">
        <div class="user_img">
            <img src="${pageContext.request.contextPath}/resources/images/${user.imageName}" class="img">
            <h3 class="user_title">${user.name}</h3>
        </div>
            <c:choose>
                <c:when test="${user.id eq currUser.id}">
                    <div class="section1">
                    <div class="banner">
                        <h3>Personal details</h3>
                    </div>
                    <div class="user_info">
                        <c:choose>
                            <c:when test="${edit}">
                                <sf:form method="POST" modelAttribute="user" action="/edit_user/${currUser.id}">
                                    <div class="edit_col">
                                        <div class="row_info">
                                            <div class="edit_icon">
                                                <img src="${pageContext.request.contextPath}/resources/images/name.png"
                                                 class="icon"/>
                                            </div>
                                            <sf:input path="name" type="text" placeholder="Name"
                                                      class="edit_text"/>
                                        </div>
                                        <div class="row_info">
                                            <div class="edit_icon">
                                                <img src="${pageContext.request.contextPath}/resources/images/email.png"
                                                 class="icon"/>
                                            </div>
                                            <sf:input path="email" type="email" placeholder="Email Address"
                                                      class="edit_text"/>
                                        </div>
                                        <div class="row_info">
                                            <div class="edit_icon">
                                                <img src="${pageContext.request.contextPath}/resources/images/phone.png"
                                                 class="icon"/>
                                            </div>
                                            <sf:input path="phone" type="number" placeholder="Phone number"
                                                      class="edit_text" required="required"/>
                                        </div>
                                        <c:if test="${not organization}">
                                            <div class="row_info">
                                                <div class="edit_icon">
                                                    <img src="${pageContext.request.contextPath}/resources/images/calendar.png"
                                                     class="icon"/>
                                                </div>
                                                <sf:input path="birthDate" type="date" placeholder="Date of birth"
                                                          class="edit_text"/>
                                            </div>
                                        </c:if>
                                        <c:if test="${organization}">
                                            <div class="row_info">
                                                <div class="edit_icon">
                                                    <img src="${pageContext.request.contextPath}/resources/images/bio.png"
                                                         class="icon"/>
                                                </div>
                                                <sf:input path="bio" type="text" placeholder="About" class="edit_text"/>
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="edit_col">
                                        <c:if test="${not empty error}">
                                            <div class="error">
                                                    ${error}
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="edit_col">
                                        <div class="edit">
                                            <div class="edit_btn">
                                                <input class="btn" type="submit" VALUE="OK"/>
                                            </div>
                                        </div>
                                    </div>
                                </sf:form>

                                <sf:form method="POST" modelAttribute="course" action="/add_course/${currUser.id}">
                                    <div>
                                        <p> Courses: </p>
                                    </div>
                                    <div>
                                        <sf:input path="cname" type="text" placeholder="Course name" class="edit_text"/>
                                        <div class="course_list">
                                            <c:forEach var="course" items="${courses}" varStatus="status">
                                                <div class="course_item">
                                                    <p>${course.cname}</p>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div>
                                        <input class="btn" type="submit" VALUE="Add"/>
                                    </div>
                                </sf:form>


                            </c:when>
                            <c:otherwise>
                                <div class="col">
                                    <div class="row_info">
                                        <img src="${pageContext.request.contextPath}/resources/images/name.png"
                                             class="icon"/>
                                        <p>${user.name}</p>
                                    </div>
                                    <div class="row_info">
                                        <img src="${pageContext.request.contextPath}/resources/images/email.png"
                                             class="icon"/>
                                        <p>${user.email}</p>
                                    </div>
                                    <div class="row_info">
                                        <img src="${pageContext.request.contextPath}/resources/images/phone.png"
                                             class="icon"/>
                                        <p>${user.phone}</p>
                                    </div>
                                    <c:if test="${not organization}">
                                        <div class="row_info">
                                            <img src="${pageContext.request.contextPath}/resources/images/calendar.png"
                                                 class="icon"/>
                                            <p>${fn:substring(user.birthDate, 0, 10)}</p>
                                        </div>

                                        <%-- Course List --%>

                                        <div class="row_info">
                                            <p>Courses:</p>
                                            <div class="course_list">
                                                <c:forEach var="course" items="${courses}" varStatus="status">
                                                    <div class="course_item">
                                                        <p>${course.cname}</p>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${organization}">
                                        <div class="row_info">
                                            <img src="${pageContext.request.contextPath}/resources/images/bio.png"
                                                 class="icon"/>
                                            <p>${user.bio}</p>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="col"></div>
                                <div class="col">
                                    <div class="edit">
                                        <div class="edit_btn">
                                            <a href="/edit_user/${currUser.id}" class="btn">Edit</a>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    </div>
                    <div class="section2">
                        <c:choose>
                            <c:when test="${not empty jobs}">
                                <div class="banner">
                                    <h3>List of applications</h3>
                                </div>
                                <c:forEach var="job" items="${jobs}" varStatus="status">
                                    <div class="list">
                                        <div class="list_item">
                                            <a href="/ad/${job.id}" class="ad_info">
                                                <div class="col2">
                                                    <div class="job_img"><img
                                                            src="${pageContext.request.contextPath}/resources/images/${job.imageName}">
                                                    </div>
                                                </div>
                                                <div class="col2">
                                                    <h3 class="job_title">${job.name}</h3>
                                                    <p class="job_desc">${fn:substring(job.description, 0,210)}</p>
                                                </div>
                                            </a>
                                            <div class="ad_btn"><a href="/ad/${job.id}/unapply" class="btn">Unapply</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                        </c:choose>

                        <c:choose>
                            <c:when test="${not empty own_ads}">
                                <div class="banner">
                                    <h3>List of ads</h3>
                                </div>
                                <c:forEach var="job" items="${own_ads}" varStatus="status">
                                    <div class="list">
                                        <div class="list_item">
                                            <a href="/ad/${job.id}" class="ad_info">
                                                <div class="col2">
                                                    <div class="job_img"><img
                                                            src="${pageContext.request.contextPath}/resources/images/${job.imageName}">
                                                    </div>
                                                </div>
                                                <div class="col2">
                                                    <h3 class="job_title">${job.name}</h3>
                                                    <p class="job_desc">${fn:substring(job.description, 0,210)}</p>
                                                </div>
                                            </a>
                                            <div class="ad_btn"><a href="/ad/${job.id}/delete" class="btn">Remove</a>
                                            </div>

                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="logout_btn">
                        <a href="/delete/${user.id}" class="btn"
                           onclick="return confirm('Are you sure you want to delete this account?');">Delete account</a>
                        <a href="/logout" class="btn">Log out</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="banner">
                        <h3>About</h3>
                    </div>
                    <p class="about">${user.bio}</p>
                    <c:choose>
                        <c:when test="${not empty own_ads}">
                            <div class="banner">
                                <h3>List of ads</h3>
                            </div>
                            <c:forEach var="job" items="${own_ads}" varStatus="status">
                                <div class="list">
                                    <div class="list_item">
                                        <a href="/ad/${job.id}" class="ad_info">
                                            <div class="col2">
                                                <div class="job_img"><img
                                                        src="${pageContext.request.contextPath}/resources/images/${job.imageName}">
                                                </div>
                                            </div>
                                            <div class="col2">
                                                <h3 class="job_title">${job.name}</h3>
                                                <p class="job_desc">${fn:substring(job.description, 0,210)}</p>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
    </div>
</main>
</body>
</html>