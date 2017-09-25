<%-- 
    Document   : login
    Created on : Sep 18, 2017, 1:06:15 PM
    Author     : 579957
--%>

<c:import url="/includes/header/html" />

        <div>
            <form action="Login" method="POST">
        <h1>Login</h1>
        Username: <input type="text" name="user" value="${username}"><br>
        Password: <input type="text" name="pass" value="${password}"><br>
        <input type="submit" value="Login">
        </form>
        </div>
        ${errorMessage}
        ${logout}

        <c:import url="/includes/footer.html" />
