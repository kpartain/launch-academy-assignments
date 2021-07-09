<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a New Order</title>
</head>
<body>
<h1>Add an order</h1>
<form action="/orders" method="POST">
<%--    private String username;--%>
    <div>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" value="" required/>
    </div>
<%--    private String itemName;--%>
    <div>
        <label for="itemName">Item name</label>
        <input type="text" id="itemName" name="itemName" value="" required/>
    </div>
<%--    private Integer itemQuantity;--%>
    <div>
        <label for="itemQuantity">Quantity</label>
        <input type="number" id="itemQuantity" name="itemQuantity" value="" required/>
    </div>
<%--    private Boolean glutenFree;--%>
    <div>
        <td>Gluten Free?</td>
        <td><input type="radio" name="glutenFree" value="False" checked>
            False</td>
        <td><input type="radio" name="glutenFree" value="True">
            True</td>
    </div>
<%--    private String imageUrl;--%>
    <div>
        <label for="imageUrl">Image URL</label>
        <input type="text" id="imageUrl" name="imageUrl" value="" required/>
    </div>

    <input type="submit" value="submit your game results" />
</form>
</body>
</html>