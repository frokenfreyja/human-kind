<!DOCTYPE html>

<html lang="en">

    <head>
       <%-- <title>"${ad.name}"</title> --%>
    </head>

    <body>
        <p>Name: "${ad.name}"</p>
        <p>Image:<img src="${pageContext.request.contextPath}/resources/images/${ad.imageName}" />
        <p>Owner: "${owner.name}"</p>
        <p>Date: "${ad.date}"</p>
        <p>Duration: "${ad.duration}"</p>
        <p>Location: "${ad.location}"</p>
        <p>Zip: "${ad.zipcode}"</p>
        <p>Description: "${ad.description}"</p>
        <p>Payout:
    </body>
</html>
