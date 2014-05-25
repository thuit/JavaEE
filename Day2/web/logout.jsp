<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-25
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>LOGOUT page</h1>
<%
    session.invalidate();//logout
%>
<a href="index.jsp">INDEX page</a>
</body>
</html>
