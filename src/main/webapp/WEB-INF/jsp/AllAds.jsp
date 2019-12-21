<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


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
        <sf:form action="sortcategory" name="formcategory" modelAttribute="work">
            <div class="sort">
            <h4 class="label">Sort by:</h4>
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

            <sf:select class="dropdwn" path="organization" onChange="this.form.submit()">
                <sf:option value="Organization" style="display: none;">${organization}</sf:option>
                <sf:option value="none" disabled="true">Organization</sf:option>
                <sf:option value="All">All organizations</sf:option>
                <sf:options items="${organizationValues}"/>
            </sf:select>
            </div>
        </sf:form>
        </div>
        </div>
        <c:choose>
            <c:when test="${not empty work_list}">
        <div class="advertlist">
                <div class="list">
                    <c:forEach var="work" items="${work_list}">
                        <div class="ad">
                            <a href="/ad/${work.id}">
                                <div class="img"><img src="${pageContext.request.contextPath}/resources/images/${work.imageName}" /></div>
                                    ${fn:substring(work.date, 0,10)}
                                <div class="card_title">
                                        ${work.name}
                                </div>
                            </a>

                        </div>
                    </c:forEach>
                </div>
            </c:when>
            <%--If all tests are false, then do this--%>
            <c:otherwise>
                <h3>No available job ads</h3>
            </c:otherwise>
        </c:choose>
</main>
</body>
</html>
