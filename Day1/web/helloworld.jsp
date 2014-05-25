<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-24
  Time: 下午1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    if (exception != null) {
        exception.getMessage();
    }
    int times = Integer.parseInt(request.getParameter("times"));
    for (int i = 0; i < times; i++) {
        out.print("Hello, world!");
    }
%>
</body>
</html>
