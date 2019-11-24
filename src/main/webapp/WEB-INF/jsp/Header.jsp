<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">

    <script type="text/javascript">
        function toggleSidebar(){
            document.getElementById("sidebar").classList.toggle('active');
        }
    </script>
</head>
<header class="header">
    <c:choose>
        <c:when test="${header_type eq 'red_bar'}">
            <h3 class="home_btn" id="red"><a href="/">HUMAN-KIND</a></h3>
        </c:when>
        <c:otherwise>
            <h3 class="home_btn" id="not_red"><a href="/">HUMAN-KIND</a></h3>
        </c:otherwise>
    </c:choose>
    <c:choose>
    <c:when test="${header_type eq 'red_bar'}">
        <div class="red_sidebar" id="sidebar">
            <div class="toggle-btn" onclick="toggleSidebar()">
                <a>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
            </div>
            <ul>
                <c:choose>
                    <c:when test="${not empty currentUser}">
                    <c:if test="${not currentUserOrgi}">
                        <li><a href="/all_ads">Available jobs</a></li>
                    </c:if>
                    <li><a href="/user/${currentUser}">My account</a></li>
                    <c:if test="${currentUserOrgi}">
                        <li><a href="/new_ad">Post ad</a></li>
                    </c:if>
                    <li><a href="/logout">Log out (${currentUsername})</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/all_ads">Available jobs</a></li>
                    <li><a href="/about">About us</a></li>
                    <li><a href="/login">Log in</a></li>
                </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </c:when>
    <c:otherwise>
        <div class="not_red_sidebar" id="sidebar">
            <div class="toggle-btn" onclick="toggleSidebar()">
                <a>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
            </div>
            <ul>
                <c:choose>
                    <c:when test="${not empty currentUser}">
                        <li><a href="/all_ads">Available jobs</a></li>
                        <li><a href="/user/${currentUser}">My account</a></li>
                        <li><a href="/logout">Log out (${currentUsername})</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/all_ads">Available jobs</a></li>
                        <li><a href="/about">About us</a></li>
                        <li><a href="/login">Log in</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </c:otherwise>
    </c:choose>

</header>