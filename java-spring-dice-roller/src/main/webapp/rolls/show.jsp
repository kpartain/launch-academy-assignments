<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Spring Dice Roll</title>
</head>
<body>
<h1>Java Spring Dice Roller</h1>
<p>
    <c:out value="${guess}" />
</p>
<p>
    <c:out value="${roll}" />
</p>
<p style="${styling}">
    <c:out value="${message}"/>
</p>
</body>
</html>