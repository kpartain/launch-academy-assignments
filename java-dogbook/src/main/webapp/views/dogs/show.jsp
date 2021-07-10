<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.launchacademy.dogbook.Dog" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doggos</title>
</head>
<body>
<h1><c:out value="${breedFromHeader}"/></h1>
<c:forEach var="dog" items="${requestScope.allDogsInBreed}">
    <h2>
        <c:out value="${dog.lastName}"/>,
        <c:out value="${dog.firstName}"/>

    </h2>
    <img src=${dog.photoUrl} alt="${dog.firstName}" style="max-width:250px;"/>
</c:forEach>
</body>
</html>