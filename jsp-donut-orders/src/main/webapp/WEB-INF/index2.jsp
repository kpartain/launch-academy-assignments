<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Random"%>

<!DOCTYPE html>
<html>
  <head>
  <title>JSP Donut Orders</title>
  </head>
  <body>
  <h2>Donut Orders</h2>
    <%! String getFormattedDate() {
          Date currentDate = new Date();
          return currentDate.toLocaleString();
    } %>
    <p>The date is <%= getFormattedDate() %></p>
   <%
     HashMap<String, Integer> donutOrders = new HashMap<String, Integer>();
     donutOrders.put("potato", 13);
     donutOrders.put("Alerererx", 4);
     donutOrders.put("Caraqedeadwly", 5);
   %>
<ul>
<%
Set<String> names = donutOrders.keySet();
int totalDonuts = 5;
HashMap<String, String> favoriteDonuts = new HashMap<String, String>();
String[] randomDonuts = {"boston cream pie","apple fritter","maple glazed","cronut",
"classic glazed","voodoo bubble","the homer","voodoo doll","shot glass of vodka"};
Random random = new Random();
  for(String name : names) {
    favoriteDonuts.put(name, randomDonuts[random.nextInt(randomDonuts.length)]);
  }
  for(String name : names) {
  if(donutOrders.get(name) < 6) {
    out.println("<li>" + name + ": " + donutOrders.get(name)
    + " whose favorite is " + favoriteDonuts.get(name) + "</li>");
    totalDonuts += donutOrders.get(name);
  } else if(donutOrders.get(name) > 5){
    out.println("<li> talk to " + name + ", whose favorite is " + favoriteDonuts.get(name) +
    ", about not trying to game the donut system. Get two instead. </li>");
    donutOrders.replace(name, 2);
    totalDonuts += donutOrders.get(name);
  }
}
out.println("<li> total number of donuts: " + totalDonuts + "</li>");
 %>
 </ul>
   </body>
</html>