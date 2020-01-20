<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="Header.jsp" />

<html lang="en">

    <head>
           <title>${ad.name}</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/ad_detail.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/grid.css"/>"/>
    <script type="text/javascript">
        window.onload = function() {
            // Get the modal
            var modal = document.getElementById("myModal");

            // Get the image and insert it inside the modal - use its "alt" text as a caption
            var img = document.getElementById("myImg");
            var modalImg = document.getElementById("img01");
            var captionText = document.getElementById("caption");
            img.onclick = function(){
                modal.style.display = "block";
                modalImg.src = this.src;
                captionText.innerHTML = this.alt;
            }

            // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];

            // When the user clicks on <span> (x), close the modal
            span.onclick = function() {
                modal.style.display = "none";
            }
        }
    </script>
    </head>

    <!-- The Modal -->
    <div id="myModal" class="modal">

        <!-- The Close Button -->
        <span class="close">&times;</span>

        <!-- Modal Content (The Image) -->
        <img class="modal-content" id="img01">

        <!-- Modal Caption (Image Text) -->
        <div id="caption"></div>
    </div>

    <body>
    <main>
        <div class="row">

            <div class="first_row">
                <div class="ad_img">
                    <img id="myImg" alt="${ad.name}" src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" />
                </div>
                <!-- Trigger the Modal -->
                <div class="first_info">
                    <div class="ad_info">
                        <h2 class="ad_title">${ad.name}</h2>
                        <p>${genLoc}</p>
                    </div>
                    <div class="ad_owner">
                        <a href="/user/${ad.owner}">
                            <div class="owner_img">
                                <img class="img" src="${pageContext.request.contextPath}/resources/images/${owner.imageName}"/>
                            </div>
                            ${owner.name}
                        </a>
                    </div>
                </div>
            </div>
            <div class="second_row">
                <div class="banner">
                    <h3>Information</h3>
                    <c:choose>
                        <c:when test="${empty edit_ad}">
                            <c:if test="${currUser.orgi && currUser eq owner && not ad.closed}">
                                <a href="/ad/${id}/edit_ad" class="edit__btn">Edit</a>
                            </c:if>
                        </c:when>
                    </c:choose>
                </div>
                <div class="second_info">
                    <h4>Description</h4>
                    <p>${ad.description}</p>

                    <div class="third_row">
                        <div class="content">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/resources/images/datetime.png" class="icon"/>
                                <div class="info_section">
                                    <h4>Date and time</h4>
                                    <fmt:formatDate type="both" value="${ad.date}"/>
                                </div>
                            </div>
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/resources/images/category.png" class="icon"/>
                                <div class="info_section">
                                    <h4>Category</h4>
                                    <p>${ad.interest}</p>
                                </div>
                            </div>
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/resources/images/location.png" class="icon"/>
                                <div class="info_section">
                                    <h4>Location</h4>
                                    <p>${ad.location}</p>
                                </div>
                            </div>
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/resources/images/zip.png" class="icon"/>
                                <div class="info_section">
                                    <h4>Zip</h4>
                                    <p>${ad.zipcode}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

                <c:if test="${not empty currUser && not currUser.orgi && not alreadyApplied && not ad.closed}">
                    <div class="delete_btn">
                        <a href="/ad/${id}/apply" class="d_btn">Apply</a>
                    </div>
                </c:if>
                <c:if test="${not empty currUser && not currUser.orgi && alreadyApplied && not ad.closed}">
                    <div class="delete_btn">
                        <a href="/ad/${id}/unapply" class="d_btn">Unapply</a>
                    </div>
                </c:if>
                <c:if test="${ad.closed}">
                   <div class="closed_txt">
                        <p> Sorry but this ad has been close </p>
                   </div>
                </c:if>
            <c:choose>
                <c:when test="${not empty applicants}">
                <div class="fourth_row">
                    <div class="banner">
                        <h3>List of applicants</h3>
                    </div>
                    <c:forEach var="applicant_list" items="${applicants}" varStatus="status">
                        <c:choose>
                            <c:when test="${accepted[status.index].accepted}">
                                <div class="applicant_item_green">
                                    <div class="col1">
                                        <a href="/user/${applicant_list.id}" class="user_a">
                                            <p>${status.index+1}. ${applicant_list.name}</p>
                                        </a>
                                    </div>

                                    <div class="col2">
                                        <c:if test="${not empty currUser && currUser.orgi && not ad.closed}">
                                            <c:if test="${not accepted[status.index].accepted && not accepted[status.index].rejected}">
                                             <div class="applicant_btn">
                                                 <a href="/ad/${id}/${applicant_list.id}/accept">Accept</a>
                                             </div>
                                                <div class ="applicant_btn">
                                                    <a href="/ad/${id}/${applicant_list.id}/reject">Reject</a>
                                                </div>
                                            </c:if>
                                        </c:if>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test ="${accepted[status.index].rejected}">
                                <div class="applicant_item_red">
                                    <div class="col1">
                                            <a href="/user/${applicant_list.id}" class="user_a">
                                                <p>${status.index+1}. ${applicant_list.name}</p>
                                            </a>
                                    </div>

                                    <div class="col2">
                                        <c:if test="${not empty currUser && currUser.orgi && not ad.closed}">
                                            <c:if test="${not accepted[status.index].accepted && not accepted[status.index].rejected}">
                                             <div class="applicant_btn">
                                                 <a href="/ad/${id}/${applicant_list.id}/accept">Accept</a>
                                             </div>
                                                <div class ="applicant_btn">
                                                    <a href="/ad/${id}/${applicant_list.id}/reject">Reject</a>
                                                </div>
                                            </c:if>
                                        </c:if>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="applicant_item">
                                    <div class="col1">
                                            <a href="/user/${applicant_list.id}" class="user_a">
                                                <p>${status.index+1}. ${applicant_list.name}</p>
                                            </a>
                                    </div>

                                    <div class="col2">
                                        <c:if test="${not empty currUser && currUser.orgi && not ad.closed}">
                                            <c:if test="${not accepted[status.index].accepted && not accepted[status.index].rejected}">
                                             <div class="applicant_btn">
                                                 <a href="/ad/${id}/${applicant_list.id}/accept" class="btn">Accept</a>
                                             </div>
                                                <div class ="applicant_btn">
                                                    <a href="/ad/${id}/${applicant_list.id}/reject" class="btn">Reject</a>
                                                </div>
                                            </c:if>
                                        </c:if>
                                    </div>
                                </div>
                             </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
                </c:when>
            </c:choose>
            <div>
        </div>
        </div>
    </main>
    </body>
</html>
