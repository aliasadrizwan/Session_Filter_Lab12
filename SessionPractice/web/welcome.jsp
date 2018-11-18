<%--
  Created by IntelliJ IDEA.
  User: Ali Asad
  Date: 11/18/2018
  Time: 4:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome <%= request.getSession().getAttribute("user") %></h1>
<a href="logout">Logout</a>
</body>
</html>
