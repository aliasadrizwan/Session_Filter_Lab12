<%--
  Created by IntelliJ IDEA.
  User: Ali Asad
  Date: 11/18/2018
  Time: 4:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="login">
    <label for="user">User Name: </label>
    <input type="text" name="user" id="user" value=<%= (request.getSession().getAttribute("user")!=null)?request.getSession().getAttribute("user"):""%> >
    <label for="password">Password: </label>
    <input type="password" name="password" id="password" />
    <label for="remember">Remember Me: </label>
    <input type="checkbox" name="remember" id="remember" <%= (request.getSession().getAttribute("remember") != null)?"checked":"" %> />
    <input type="submit" name="submit" id="submit" />
</form>

</body>
</html>
