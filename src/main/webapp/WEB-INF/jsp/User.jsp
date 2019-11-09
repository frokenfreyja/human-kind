<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>User Page</title>
    </head>
    <body>

    <nav>
        <a href="/"> E.T. go home </a>
    </nav>
      
    <h1>My Account</h1>
    <p> Welcome ${user.name} </p>
  
    <img src="/resources/images/ricardo.gif">
    <div>
        <c:choose>
            <c:when test="${not empty jobs}">
                <c:forEach var="job" items="${jobs}">
                    <p>${job.name}<p>
                </c:forEach>
            </c:when>
                <c:otherwise>
                    No jobs applied for
                </c:otherwise>
        </c:choose>
    </div>
    <div>
        <c:choose>
            <c:when test="${not empty own_ads}">
                <c:forEach var="job" items="${own_ads}">
                    <p><a href="/ad/${job.id}">${job.name}</a><p>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>
    <div>
        <a href="/logout"> Sign me out home boii </a>
    </div>
    </body>

</html>