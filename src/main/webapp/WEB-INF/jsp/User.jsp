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
                        <c:choose>
                            <c:when test="${empty edit}">
                                <a href="/edit_user/${currUser.id}" class="edit__btn">Edit</a>
                            </c:when>
                            <c:otherwise>
                                <input class="edit__btn" type="submit" form="edit_form" value="OK"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="user_info">
                        <c:choose>
                            <c:when test="${edit}">
                                <sf:form id="edit_form" method="POST" modelAttribute="user" action="/edit_user/${currUser.id}">
                                    <div class="edit_col">
                                        <div class="row_info">
                                            <h4 class="info">Name:</h4>
                                            <sf:input path="name" type="text" placeholder="Name" class="user"/>
                                        </div>
                                        <div class="row_info">
                                            <h4 class="info">Email:</h4>
                                            <sf:input path="email" type="email" placeholder="Email Address"
                                                      class="user"/>
                                        </div>
                                        <div class="row_info">
                                            <h4 class="info">Phone:</h4>
                                            <sf:input path="phone" type="number" placeholder="Phone number"
                                                      class="user" required="required"/>
                                        </div>
                                        <c:if test="${not organization}">
                                            <div class="row_info">
                                                <h4 class="info">Birthdate:</h4>
                                                <sf:input path="birthDate" type="date" placeholder="Date of birth"
                                                          class="user" />
                                            </div>
                                        </c:if>
                                        <c:if test="${organization}">
                                            <div class="row_info">
                                                <h4 class="info">About:</h4>
                                                <sf:textarea path="bio" type="text" placeholder="About" class="user"/>
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
                                </sf:form>

                                <c:if test="${not organization}">
                                    <sf:form method="POST" modelAttribute="course" action="/add_course/${currUser.id}">
                                                <div class="row_info">
                                                    <h4 class="info">Courses:</h4>
                                                    <div class="course_add">
                                                        <sf:input path="cname" type="text" placeholder="Course name" class="user_course"/>
                                                        <input class="course_btn" type="submit" VALUE="Add"/>
                                                    </div>
                                                </div>
                                                <div class="row_info">
                                                    <h4 class="info">Finished courses:</h4>
                                                    <div class="course_list">
                                                        <c:forEach var="course" items="${courses}" varStatus="status">
                                                                <p class="user_course">${course.cname}</p>
                                                        </c:forEach>
                                                    </div>
                                                </div>

                                    </sf:form>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <div class="information">
                                    <div class="row_info">
                                        <h4 class="info">Name:</h4>
                                        <p class="user">${user.name}</p>
                                    </div>
                                    <div class="row_info">
                                        <h4 class="info">Email:</h4>
                                        <p class="user">${user.email}</p>
                                    </div>
                                    <div class="row_info">
                                        <h4 class="info">Phone:</h4>
                                        <p class="user">${user.phone}</p>
                                    </div>
                                    <c:if test="${not organization}">
                                        <div class="row_info">
                                            <h4 class="info">Birthdate:</h4>
                                            <p class="user">${fn:substring(user.birthDate, 0, 10)}</p>
                                        </div>

                                        <%-- Course List --%>

                                        <div class="row_info">
                                            <h4 class="info">Finished courses:</h4>
                                            <div class="course_list">
                                                <c:forEach var="course" items="${courses}" varStatus="status">
                                                    <div class="course_item">
                                                        <p class="user">${course.cname}</p>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${organization}">
                                        <div class="row_info">
                                            <h4 class="info">About:</h4>
                                            <p class="user">${user.bio}</p>
                                        </div>
                                    </c:if>
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
                                    <c:if test="${not job.closed}">
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
                                                        <p class="job_desc">${fn:substring(job.description, 0,140)}</p>
                                                    </div>
                                                </a>
                                                <div class="ad_btn">
                                                    <a href="/ad/${job.id}/unapply" class="btn">Unapply</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:when>
                        </c:choose>

                        <c:choose>
                            <c:when test="${not empty compJobs}">
                                <div class="banner">
                                    <h3>List of Completed Jobs</h3>
                                </div>
                                <c:forEach var="cjob" items="${compJobs}" varStatus="status">
                                    <div class="list">
                                        <div class="list_item">
                                            <a href="/ad/${cjob.id}" class="ad_info">
                                                <div class="col2">
                                                    <div class="job_img">
                                                        <img src="${pageContext.request.contextPath}/resources/images/${cjob.imageName}">
                                                    </div>
                                                </div>
                                                <div class="col2">
                                                    <h3 class="job_title">${cjob.name}</h3>
                                                    <p class="job_desc">${fn:substring(cjob.description, 0,140)}</p>
                                                </div>
                                            </a>
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
                                                    <p class="job_desc">${fn:substring(job.description, 0,140)}</p>
                                                </div>

                                            </a>
                                            <%-- þetta á að vera not ad.closed en að ehv ástæðu virkar þetta --%>
                                            <c:if test="${ad.closed}">
                                                <div class="ad_btn">
                                                    <a href="/ad/${job.id}/delete" class="btn">Remove</a>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </div>
                    <c:choose>
                        <c:when test="${edit}">
                            <div class="delete_btn">
                                <a href="/delete/${user.id}" class="d_btn" onclick="return confirm('Are you sure you want to delete this account?');">Delete account</a>
                            </div>
                        </c:when>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${organization}">
                            <div class="section1">
                                <div class="banner">
                                    <h3>About</h3>
                                </div>
                                <p class="about">${user.bio}</p>
                            </div>
                        <div class="section2">
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
                                                        <p class="job_desc">${fn:substring(job.description, 0,140)}</p>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:when>
                            </c:choose>
                        </div>
                        </c:when>
                            <c:otherwise>
                                <div class="section1">

                                    <div class="banner">
                                        <h3>Personal information</h3>
                                    </div>
                                    <div class="about">
                                        <div class="row_info">
                                            <h4 class="info">Name:</h4>
                                            <p class="user">${user.name}</p>
                                        </div>
                                        <div class="row_info">
                                            <h4 class="info">Email:</h4>
                                            <p class="user">${user.email}</p>
                                        </div>
                                        <div class="row_info">
                                            <h4 class="info">Phone:</h4>
                                            <p class="user">${user.phone}</p>
                                        </div>
                                        <div class="row_info">
                                            <h4 class="info">Birthdate:</h4>
                                            <p clas="user">${fn:substring(user.birthDate, 0, 10)}</p>
                                        </div>

                                        <%-- Course List --%>

                                        <div class="row_info">
                                            <h4 class="info">Finished courses:</h4>
                                            <div class="course_list">
                                                <c:forEach var="course" items="${courses}" varStatus="status">
                                                    <div class="course_item">
                                                        <p class="user">${course.cname}</p>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
    </div>
</main>
</body>
</html>