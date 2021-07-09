<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Life Goals</title>
  </head>
  <body>
  <h2>Life Goals</h2>
<ul>
<% String[] myGoals = {"fulfill basic biological needs and desires",
"ascend Maslow's hierarchy of needs to achieve nirvana", "die peacefully in my sleep"};
for(int i = 0; myGoals.length > i; i++){
out.println("<li>"+myGoals[i]+"</li>");
}
%>
</ul>
  </body>
</html>