<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Doggo</title>
</head>
<body>
<h1>Add a Doggo</h1>
<form action="/dogs" method="post">
<%--private String firstName;--%>
    <div>
        <label for="firstName">First Name:        </label>
        <input type="text" id="firstName" name="firstName" required/>

    </div>
<%--private String lastName;--%>
    <div>
        <label for="lastName">Last Name:        </label>
        <input type="text" id="lastName" name="lastName" required/>

    </div>
<%--private String photoUrl;--%>
    <div>
        <label for="photoUrl">Photo URL (must be a valid image link):        </label>
        <input type="text" id="photoUrl" name="photoUrl" required/>

    </div>
<%--private String breed;--%>
    <div>
        <label for="breed">Breed:        </label>
        <input type="text" id="breed" name="breed" required/>

    </div>
<%--private String sex;--%>
    <div>
        <label for="sex">Sex:        </label>
        <input type="text" id="sex" name="sex" required/>

    </div>
<%--    submit--%>
    <div>
        <input type="submit" value="Submit Doggo"/>
    </div>
</form>
</body>
</html>