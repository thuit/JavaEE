<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Day2...</h1>
<form action="login.jsp" method="get">
    username: <input name="username"/><br>
    password: <input type="password" name="password"/><br>
    <input type="submit" value="LOGIN"/>
</form>
<em style="color: #f00;">
    <%k
        String message = (String) request.getAttribute("message");
        if (message != null) {
            out.print(message);
        }
    %>
</em><br>
<a href="signup.jsp">Sign up</a>
</body>
</html>