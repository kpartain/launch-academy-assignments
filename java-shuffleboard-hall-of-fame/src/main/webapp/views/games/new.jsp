<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a New Game</title>
</head>
<body>
<h1>Add Game Results</h1>
<form action="/games" method="post">
<%--    red team--%>
    <h2>Red team</h2>
    <div>
        <label for="redTeamPlayerOne" style="color :red; ">Player One</label>
        <input type="text" id="redTeamPlayerOne" name="redTeamPlayerOne" value="" required/>
    </div>
    <div>
        <label for="redTeamPlayerTwo" style="color :red; ">Player Two</label>
        <input type="text" id="redTeamPlayerTwo" name="redTeamPlayerTwo" value="" required/>
    </div>
    <div>
        <label for="redTeamScore" style="color :red; ">Score</label>
        <input type="number" id="redTeamScore" name="redTeamScore" value="" required/>
    </div>
<%--    blue team--%>
    <h2>Blue Team</h2>
    <div>
        <label for="blueTeamPlayerOne" style="color :blue; ">Player One</label>
        <input type="text" id="blueTeamPlayerOne" name="blueTeamPlayerOne" value="" required/>
    </div>
    <div>
        <label for="blueTeamPlayerTwo" style="color :blue; ">Player Two</label>
        <input type="text" id="blueTeamPlayerTwo" name="blueTeamPlayerTwo" value="" required/>
    </div>
    <div>
        <label for="blueTeamScore" style="color :blue; ">Score</label>
        <input type="number" id="blueTeamScore" name="blueTeamScore" value="" required/>
    </div>

    <input type="submit" value="submit your game results" />
</form>
</body>
</html>