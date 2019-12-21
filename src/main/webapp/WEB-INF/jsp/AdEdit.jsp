<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="Header.jsp" />

<html lang="en">

    <head>
           <title>${ad.name}</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/ad_edit.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/grid.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/button.css"/>"/>

    </head>

    <body>
    <main>
        <div class="row">
            <div class="ad_img">
                <img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" />
            </div>
            <sf:form method="POST" modelAttribute="ad" action="/ad/${id}/edit_ad"  enctype="multipart/form-data">

                    <div class="ad_info">

                        <div class="info_section">
                            <p class="info_section_title">Name</p>
                            <div class="input">
                                <sf:input path="name" class="ad_text" type="text" placeholder="${name}" required="required"/>
                            </div>
                        </div>
                        <div class="info_section">
                            <p class="info_section_title">Date and time</p>
                            <div class="input">
                                <sf:input path="date" class="ad_text" type="datetime-local" placeholder="Date" value="2020-06-01T08:30" required="required" />
                            </div>
                        </div>

                        <div class="info_section">
                            <p class="info_section_title">Interest</p>
                            <div class="input">
                                <sf:select path="interest" class="ad_text">
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

                        <div class="info_section">
                            <p class="info_section_title">Location</p>
                            <div class="input">
                                <sf:input path="location" class="ad_text" type="text" placeholder="${location}" required="required"/>
                            </div>
                        </div>

                        <div class="info_section">
                            <p class="info_section_title">Zip</p>
                            <div class="input">
                                <sf:input path="zipcode" class="ad_text" type="text" placeholder="${zipcode}" required="required"/>
                            </div>
                        </div>


                        <div class="info_section">
                            <p class="info_section_title">Description</p>
                            <div class="input">
                                <sf:textarea path="description" class="input_desc" type="text" placeholder="${description}" required="required"/>
                            </div>
                        </div>
                    </div>

                <div class="ad_btn">
                    <input type="submit" class="btn" value="Apply Changes" />
                </div>
            </sf:form>
        </div>
        </div>
    </main>
    </body>
</html>
