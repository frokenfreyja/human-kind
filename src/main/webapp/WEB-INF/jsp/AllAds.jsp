<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html lang="en">

<jsp:include page="Header.jsp" />

<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,500,600,700|Muli:600|Rubik:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/all_ads.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    <title>Ads</title>
</head>
<body>
<main>
    <%-- Ef til eru auglýsingar, birtir lista af öllum auglýsingum í töflu --%>
    <%--Fyrir hvert Item, sem er á listanum sem var sett í módelið er búin til röð í töflunni--%>
    <h2 class="advert">AVAILABLE JOBS</h2>
        <c:choose>
            <c:when test="${not empty work_list}">
            <%-- Leitargluggi sem leitar í auglýsingalista eftir leitarorðum--%>
        <div class="searchfield">
            <form object="${items}" id="searchlist" action="searchlistx" method="get">
                <table class="search">
                    <tr>
                        <td class="searchicon">
                            <i class="fa fa-search"></i>
                        </td>
                        <td>
                            <input type="text" class="searcher" value="${search}" name="searching" placeholder=" Setjið inn leitarorð.." onChange="this.form.submit()" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>

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
<jsp:include page="Footer.jsp" />
</html>
