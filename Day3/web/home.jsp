<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-25
  Time: 上午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>HOME page</h1>
<%=session.getAttribute("username")%>
<hr/>
<a href="logout.jsp">LOGOUT</a>
</body>
</html>
