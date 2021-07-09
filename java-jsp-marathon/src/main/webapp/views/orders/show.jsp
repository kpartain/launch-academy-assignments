<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.launchacademy.orders.models.Order" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="orders" value="${requestScope.orders}" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Show Page</title>
</head>
<body>
<h1>Ordered by: <c:out value="${order.userName}"/></h1>
<%--item's name, --%>
<h2>Item Ordered: <c:out value="${order.itemName}"/></h2>
<%--quantity, and --%>
<h2>Quantity: <c:out value="${order.itemQuantity}"/></h2>
<%--photo. --%>
<img src="<c:out value="${order.imageUrl}"/>" alt="picture of <c:out value="${order.itemName}"/>" />

<%--display "GF" if gluten free is true. else display nothing. --%>
<c:choose>
    <c:when test="${order.glutenFree==true}">
        <p>This Item is Gluten Free</p>
    </c:when>
    <c:otherwise>
<%--        not gluten free, display nothing--%>
    </c:otherwise>
</c:choose>
</body>
</html>