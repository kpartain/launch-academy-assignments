<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.launchacademy.games.Game" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="games" value="${requestScope.games}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Games</title>
</head>
    <body>
        <div>
            <ul>
                <c:forEach items="${games}" var="game">
                    <li style="color :red; ">Red Team</li>
                    <li style="color :red; ">
                        <c:out value="${game.redTeamPlayerOne}" />
                        <c:out value="${game.redTeamPlayerTwo}" />
                        <c:out value="${game.redTeamScore}"/>
                    </li>
                    <li style="color :blue; ">Blue Team</li>
                    <li style="color :blue; ">
                        <c:out value="${game.blueTeamPlayerOne}" />
                        <c:out value="${game.blueTeamPlayerTwo}" />
                        <c:out value="${game.blueTeamScore}"/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>