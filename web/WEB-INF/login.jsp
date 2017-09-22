<%-- 
    Document   : login
    Created on : Sep 18, 2017, 1:06:15 PM
    Author     : 579957
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week02Lab2</title>
    </head>
    <body>
        <div>
            <form action="Login" method="POST">
        <h1>Login</h1>
        Username: <input type="text" name="username" value="${username}"><br>
        Password: <input type="text" name="password" value="${password}"><br>
        <input type="submit" value="Login">
        </form>
        </div>
        ${errorMessage}
        ${logout}
    </body>
</html>
