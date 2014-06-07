<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-25
  Time: 上午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>sign up page</h1>

<form action="register" method="post">
    username: <input name="username"><br>
    password: <input type="password" name="password"><br>
    city: <select multiple="multiple" name="city">
                <option value="Beijing">Beijing</option>
                <option value="Shanghai">Shanghai</option>
                <option value="Guangzhou">Guangzhou</option>
            </select><br>
    hobbies: <input type="checkbox" name="hobbies" value="study0">study0
                <input type="checkbox" name="hobbies" value="study1">study1
                <input type="checkbox" name="hobbies" value="study2">study2
                <input type="checkbox" name="hobbies" value="study3">study3
                <input type="checkbox" name="hobbies" value="study4">study4
                <input type="checkbox" name="hobbies" value="study5">study5<br>
    <input type="submit" value="SIGN UP">
</form>
</body>
</html>
