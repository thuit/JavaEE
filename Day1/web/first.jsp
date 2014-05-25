<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-24
  Time: 上午11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <tr>
        <th>NAME</th>
        <th>ID</th>
    </tr>
    <%
        String c1 = "#9cf";
        String c2 = "#8c3";
        for (int i = 0; i < 10; i++) {
            String c;
            if (i % 2 == 0) {
                c = c1;
            } else {
                c = c2;
            }
            out.println("<tr bgcolor=\"" + c + "\">");
            out.println("<td>name:" + i + "</td>");
            out.println("<td>id:" + i + "</td>");
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>
