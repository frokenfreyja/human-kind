<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>User Page</title>
    </head>
    <body>


    <nav>
        <a href="/"> E.T. go home </a>
    </nav>
      
    <h1>My Account</h1>
    <p> Welcome ${user.name} </p>
  
    <img src="/resources/images/ricardo.gif">
    <div>
        <a href="/logout"> Sign me out home boii </a>
    </div>

    </body>

</html>