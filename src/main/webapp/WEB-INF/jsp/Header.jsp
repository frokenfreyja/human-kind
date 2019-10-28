<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    <script type="text/javascript">
        function toggleSidebar(){
            document.getElementById("sidebar").classList.toggle('active');
        }
    </script>
</head>
<header class="header">
    <div id="sidebar">
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
                <li><a href="/all_ads">AVAILABLE JOBS</a></li>
                <li><a href="/my_account">MY ACCOUNT</a></li>
                <li><a href="/logout">SIGN OUT (${currentUsername})</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="/all_ads">AVAILABLE JOBS</a></li>
                <li><a href="/about">ABOUT US</a></li>
                <li><a href="/login">SIGN IN</a></li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</header>