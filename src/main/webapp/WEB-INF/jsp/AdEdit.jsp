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
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/button.css"/>"/>

            <script>
                   var loadFile = function(event) {
                       var image = document.getElementById('myImg');
                       image.src = URL.createObjectURL(event.target.files[0]);
                   }
            </script>
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
                <sf:form method="POST" modelAttribute="ad" action="/ad/${id}/edit_ad"  enctype="multipart/form-data" id="edit_ad_form">
                    <div class="ad_img">
                        <img id="myImg" alt="${ad.name}" src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" />
                    </div>
                    <div class="btn_img">
                        <sf:label for="image" class="img_btn" path="image" style="cursor: pointer;">Change image</sf:label>
                    </div>
                    <sf:input path="image" type="file" id="image" accept="image/*" name="image" onchange="loadFile(event)" style="display: none;" multiple="multiple" />

                            <div class="first_info">
                                <div class="ad_info">
                                    <h4>Title</h4>
                                    <sf:input path="name" class="input" type="text" placeholder="${name}" required="required"/>
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
                                <h3>Edit ad</h3>
                                <input class="edit__btn" type="submit" form="edit_ad_form" value="OK"/>
                            </div>
                            <div class="second_info">
                                <h4>Description</h4>
                                <sf:textarea path="description" class="input" type="text" placeholder="${description}" required="required"/>
                                <h4>Acceptance message</h4>
                                <sf:textarea path="msg" class="input" type="text" placeholder="${msg}" required="required"/>
                            </div>
                            <div class="third_row">
                                <div class="content">
                                    <div class="card">
                                        <img src="${pageContext.request.contextPath}/resources/images/datetime.png" class="icon"/>
                                        <div class="info_section">
                                            <h4>Date and time</h4>
                                            <sf:input path="date" class="ad_text" type="datetime-local" placeholder="Date" value="2020-06-01T08:30" required="required" />
                                        </div>
                                    </div>
                                    <div class="card">
                                        <img src="${pageContext.request.contextPath}/resources/images/category.png" class="icon"/>
                                        <div class="info_section">
                                            <h4>Category</h4>
                                            <sf:select path="interest" class="select">
                                                <sf:option value="cat" style="display: none;">Category</sf:option>
                                                <sf:option value="none" disabled="true">Category</sf:option>
                                                <sf:option value="Nature">Nature</sf:option>
                                                <sf:option value="Animals">Animals</sf:option>
                                                <sf:option value="People">People</sf:option>
                                                <sf:option value="Clothing">Clothing</sf:option>
                                                <sf:option value="Food">Food</sf:option>
                                                <sf:option value="Other">Other</sf:option>
                                            </sf:select>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <img src="${pageContext.request.contextPath}/resources/images/location.png" class="icon"/>
                                        <div class="info_section">
                                            <h4>Location</h4>
                                            <sf:input path="location" class="input" type="text" placeholder="${location}" required="required"/>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <img src="${pageContext.request.contextPath}/resources/images/zip.png" class="icon"/>
                                        <div class="info_section">
                                            <h4>Zip</h4>
                                            <sf:input path="zipcode" class="input" type="text" placeholder="${zipcode}" required="required"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                </sf:form>
            </div>
            <div class="delete_btn">
                <a href="/ad/${id}/delete" class="d_btn" onclick="return confirm('Are you sure you want to delete this ad?');">Remove ad</a>
            </div>
        </div>
    </main>
    </body>
</html>
