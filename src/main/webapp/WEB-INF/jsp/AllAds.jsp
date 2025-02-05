<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<html lang="en">

<jsp:include page="Header.jsp" />

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/all_ads.css"/>"/>
    <title>Ads</title>
</head>
<body>
<main>
    <div class="content">
    <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
    <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
    <h2 class="advert">AVAILABLE JOBS</h2>
        <%-- Leitargluggi sem leitar í auglýsingalista eftir leitarorðum--%>
        <div class="sort_search">
        <div class="row">
                <sf:form id="searchlist" action="searchlistx" method="get">
                    <div class="search">
                        <h4 class="label">Search:</h4>
                        <input type="text" class="search_input" value="${search}" name="searching" onChange="this.form.submit()" />
                    </div>
                </sf:form>
        </div>
        <div class="row">
            <div class="sort">
            <h4 class="label">Sort by:</h4>
                <sf:form action="sortloc" modelAttribute="ad">
                    <sf:select class="dropdwn" path="genLoc" onChange="this.form.submit()">
                        <sf:option value="Location" style="display: none;">${genLoc}</sf:option>
                        <sf:option value="none" disabled="true">Location</sf:option>
                        <sf:option value="All">All locations</sf:option>
                        <sf:option value="Höfuðborgarsvæðið">Höfuðborgarsvæðið</sf:option>
                        <sf:option value="Vesturland">Vesturland</sf:option>
                        <sf:option value="Vestfirðir">Vestfirðir</sf:option>
                        <sf:option value="Norðurland">Norðurland</sf:option>
                        <sf:option value="Austurland">Austurland</sf:option>
                        <sf:option value="Suðurland">Suðurland</sf:option>
                        <sf:option value="Suðurnes">Suðurnes</sf:option>
                    </sf:select>
                </sf:form>

                <sf:form action="sortcat" modelAttribute="ad">
                    <sf:select class="dropdwn" path="interest" onChange="this.form.submit()">
                        <sf:option value="Category" style="display: none;">${interest}</sf:option>
                        <sf:option value="none" disabled="true">Category</sf:option>
                        <sf:option value="All">All categories</sf:option>
                        <sf:option value="Nature">Nature</sf:option>
                        <sf:option value="Animals">Animals</sf:option>
                        <sf:option value="People">People</sf:option>
                        <sf:option value="Clothing">Clothing</sf:option>
                        <sf:option value="Food">Food</sf:option>
                    </sf:select>
                </sf:form>

                <sf:form action="sortorg" modelAttribute="ad">
                    <sf:select class="dropdwn" path="organization" onChange="this.form.submit()">
                        <sf:option value="Organization" style="display: none;">${organization}</sf:option>
                        <sf:option value="none" disabled="true">Organization</sf:option>
                        <sf:option value="All">All organizations</sf:option>
                        <sf:options items="${organizationValues}"/>
                    </sf:select>
                </sf:form>

            </div>
        </div>
        </div>
        <c:choose>
            <c:when test="${not empty ad_list}">
        <div class="advertlist">
                <div class="list">
                    <c:forEach var="ad" items="${ad_list}">
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
            </c:when>
            <%--If all tests are false, then do this--%>
            <c:otherwise>
                <h3 class="no_available">No available job ads</h3>
            </c:otherwise>
        </c:choose>
        </div>
</main>
</body>
</html>
