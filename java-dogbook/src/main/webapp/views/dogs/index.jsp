<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.launchacademy.dogbook.Dog" %>
<c:set var="dogCookie" value="${requestScope.dogCookie}" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <title>Doggos</title>
</head>
<body>
<c:choose>
    <c:when test = "${not empty dogCookie}" >
        <p>Find Friends for <c:out value="${dogCookie}" />
    </c:when>
    <c:otherwise>
        <p>All Available Dogs</p>
        <p><a href="/dogs/new">Add Your Dog to DogBook</a></p>
    </c:otherwise>
</c:choose>
<h1>All Dogs</h1>
    <c:forEach var="dog" items="${requestScope.dogs}">
        <h2>
            <c:out value="${dog.lastName}"/>,
            <c:out value="${dog.firstName}"/>

        </h2>
        <img src=${dog.photoUrl} alt="picture of ${dog.firstName}" style="max-width:250px;"/>
    </c:forEach>
</body>
</html>