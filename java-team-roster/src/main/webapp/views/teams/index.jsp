<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.launchacademy.rosters.models.League" %>
<!DOCTYPE html>
<html>
<head>
    <titles>Teams</titles>
</head>
<body>
<h1>List of Teams for Curling</h1>
<ul>
    <c:forEach var="team" items="${requestScope.teams}" >
        <li>
            <a href="/>team?teamIndex=<c:out value="${requestScope.teams.indexOf(team)}"/>">
            <c:out value="${team.teamName}"/>
        </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
