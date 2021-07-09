<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Spring Dice Roll</title>
</head>
<body>
<h1>Java Spring Dice Roller</h1>

<hr>
<p>When I navigate to /rolls/new, the server will give me a random number between 1 and 6 Each time the die is rolled,
    it should provide a new result The web page should output You rolled a ~number
</p>
<h2 th:text="${roll}">generated roll</h2>
<h2 th:text="${guess}">guessed number</h2>
<hr>
<p>
    When I navigate to /rolls/new?guess=NUM, the system rolls a die and compares it to the supplied guess If the visitor
    guesses correctly, it should say "YOU GUESSED THE NUMBER" in bold letters If the guess was less than the number, it
    should render "Nope. Sorry. Try Again" If the guess was more than the number, it should render "Close. If we were
    playing price is right rules, you would have won." The result of the roll should still be reflected in the rendering
</p>

<hr>
<p>
    When I navigate to /rolls/new?guess=NUM&diceCount=NUMOFDICE, the NUM OF DICE should reflect the number of dice that
    are rolled. This should increase the range of the roll result. IE, if I specify 3 for the diceCount querystring
    parameter, it is possible for me to roll an 18. The number of dice parameter should be respected even if I don't
    specify a guess.When I navigate to /rolls/new?guess=NUM&diceCount=NUMOFDICE, the NUM OF DICE should reflect the
    number of dice that are rolled. This should increase the range of the roll result. IE, if I specify 3 for the
    diceCount querystring parameter, it is possible for me to roll an 18. The number of dice parameter should be
    respected even if I don't specify a guess.
</p>
</body>
</html>