<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<html class="grid" lang="en">
<head>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700|Roboto+Condensed:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/newad.css"/>"/>
    <title>Ad</title>
    <script>
        var loadFile = function(event) {
            var image = document.getElementById('output');
            image.src = URL.createObjectURL(event.target.files[0]);
        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>

</head>
<body>
<main>
    <div class="grid">
        <div class="row">
                <%-- Form til þess að skrá nýja auglýsingu--%>
                <h1 class="newadvert">NEW AD</h1>
                    <sf:form method="POST" modelAttribute="work" action="/new_ad" enctype="multipart/form-data">
                        <table class="newadvertise">
                            <tr>
                                    <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                                <td>
                                    <sf:input path="name" class="formbox" type="text" placeholder="Title" required="required" autofocus="autofocus"/>
                                </td>
                            </tr>
                            <tr>
                                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                                <td>
                                    <sf:input path="description" class="formbox" type="text" placeholder="Description" required="required" />
                                </td>
                            </tr>
                            <tr>
                                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                                <td>
                                    <sf:input path="date" class="formbox" type="text" placeholder="DD-MM-YYYY" required="required" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <sf:input path="location" class="formbox" type="text" placeholder="Location" required="required" />
                                </td>
                            </tr>
                            <tr>
                                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                                <td>
                                    <sf:input path="zipcode" class="formbox" type="text" maxlength="3" placeholder="Zip" required="required" pattern="\b(101|103|104|105|107|108|109|110|111|112|113|114|116|170|200|201|203|210|225|220|221|222|270|271|276|300|301|310|311|320|340|345|350|355|356|360|370|371|380||400|401|410|415|420|425|430|450|451|460|465|470|471|510|512|520|524|500|530|531|540|545|550|551|560|565|566|570|580|600|601|603|610|611|620|621|625|630|640|641|645|650|660|670|671|675|680|681|685|690|700|701|710|715|720|730|735|740|750|755|760|765|780|781|785|800|801|810|815|816|820|825|840|845|850|851|860|861|870|871|880|900|190|230|233|235|240|245|250|260)\b"/>
                                </td>
                            </tr>
                            <tr>
                                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                                <td>
                                    <sf:select path="interest" class="checkcategories">
                                        <sf:option value="cat" style="display: none;">Category</sf:option>
                                        <sf:option value="none">-</sf:option>
                                        <sf:option value="Nature">Nature</sf:option>
                                        <sf:option value="Animals">Animals</sf:option>
                                        <sf:option value="People">People</sf:option>
                                        <sf:option value="Clothing">Clothing</sf:option>
                                        <sf:option value="Food">Food</sf:option>
                                    </sf:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h3 class="imgbutton">
                                        <sf:label for="image" path="image" style="cursor: pointer;">UPLOAD PHOTO</sf:label>
                                    </h3>
                                </td>
                                <td>
                                    <p>
                                        <sf:input path="image" type="file" id="image" accept="image/*" name="image" onchange="loadFile(event)" style="display: none;" multiple="multiple" />
                                    </p>
                                    <p><img path="output" id="output" width="400"></p>
                                </td>
                            </tr>
                        </table>
                        <input type="submit" class="formbutton" VALUE="OK" />
                    </sf:form>
            </div>
        </div>
</main>

<footer class="footer">
    <div class="footer_content">
        <a class="footer__link" href="/facebook"><img src="/resources/images/facebook.svg" class="footer_icon"/></a>
        <a class="footer__link" href="/instagram"><img src="/resources/images/instagram.png" class="footer_icon"/></a>
        <a class="footer__link" href="/twitter"><img src="/resources/images/twitter.png" class="footer_icon"/></a>
        <a class="footer__link" href="/email"><img src="/resources/images/mailbox.png" class="footer_icon"/></a>
    </div>
</footer>
</body>
</html>