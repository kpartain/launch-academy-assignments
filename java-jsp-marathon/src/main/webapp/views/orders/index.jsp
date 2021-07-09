<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.launchacademy.orders.models.Order" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="order" value="${requestScope.orders}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Orders</title>
</head>
<body>
<h1>Bakery Orders</h1>
<div>
    <h2>Existing Orders</h2>
    <ul>
        <c:forEach items="${orders}" var="order">
            <li>
                <a href="orders?orderId=<c:out value="${order.id}"/>">
                    Item Name:
                        <c:out value="${order.itemName}"/>
                </a>
            </li>
            <li>User Name: <c:out value="${order.userName}"/></li>
        </c:forEach>
    </ul>
    <ul>
        <c:forEach items="${orders}" var="order">
            <li>
                <a href="orders?orderId=<c:out value="${order.}" "
            </li>

        </c:forEach>
    </ul>
</div>
<div>
    <h2>Order Again</h2>
    <a href="orders/new">Order Again</a>
</div>
</body>
</html>