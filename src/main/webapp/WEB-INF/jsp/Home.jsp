<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<jsp:include page="Header.jsp" />

<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/grid.css"/>"/>
        <title>Human-Kind</title>
    </head>
    <body>

    <div class="container">
    <div class="section1">
        <div class="section1_content">
            <div class="title">
                <h1>HUMAN - KIND</h1>
            </div>
            <div class="subtitle">
                <p>Be kind, be human.</p>
            </div>
            <div>
                <c:choose>
                    <c:when test="${empty currentUser}">
                        <a href="/login" class="login_btn">LOG IN</a>
                    </c:when>
                    <c:when test="${currentUserOrgi}">
                        <a href="/new_ad" class="login_btn">POST AD</a>
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>


    <div class="section2">
        <div class="row">
            <h2 class="sub">MAKING IT EASIER FOR ORGANIZATIONS TO RECRUIT VOLUNTEERS AND INSPIRE NON-VOLUNTEERS TO VOLUNTEER</h2>
            <div class="col">
                <div class="textbox_title">PROBLEM</div>
                <p>Forests on fire, polluted ocean, animal extinction, growing inequality. It's the beginning of the end of our world and the need for volunteers has never been more urgent.</p>
                <div class="textbox_title">MARKET</div>
                <p>An estimated 31.6% of Icelandic adults volunteered in 2014. More than 1 billion people volunteer worldwide, most of them ading in their own countries.</p>
                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget</p>
            </div>
            <div class="col">
                <p>volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
                <div class="textbox_title">SOLUTION</div>
                <p>We aim to streamline the process of</p>
                <div class="bil"></div>
                <p>becoming a volunteer by creating a digital platform that connects organizations with</p>
                <p> potential volunteers in a simple yet fun way! HUMAN-KIND is a free to use web-application and mobile application with advertising based revenue model.</p>
                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac</p>

            </div>
            <div class="onepager"><img src="${pageContext.request.contextPath}/resources/images/onepager.png" class="onepager_img"/></div>

            <div class="col">
                <p>condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui.
                <div class="bil"></div>
                Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat</p>
                <p>volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam,</p>

            </div>
            <div class="col">
                <p> sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis.</p>
            </div>
        </div>
        <h3 class="quote">"We believe our platform can help bridge the gap between organizations and potential volunteers."</h3>
    </div>

    <div class="section3">
        <div class="section3_content">
            <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
            <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
                <h2 class="advert">AVAILABLE JOBS</h2>
                <c:choose>
                    <c:when test="${not empty ad_list}">
                        <div class="advertlist">
                            <div class="list">
                                <c:forEach begin="0" end="9" var="ad" items="${ad_list}">
                                    <div class="ad">
                                        <a href="/ad/${ad.id}">
                                            <div class="img"><img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" /></div>
                                                ${fn:substring(ad.date, 0,10)}
                                            <div class="card_title">
                                                    ${ad.name}
                                            </div>
                                        </a>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div>
                            <a href="/all_ads" class="ads_btn">VIEW ALL</a>
                        </div>
                    </c:when>
                    <%--If all tests are false, then do this--%>
                    <c:otherwise>
                        <h3>No available job ads</h3>
                    </c:otherwise>
                </c:choose>
            </div>
    </div>
    </div>
    </body>
</html>
