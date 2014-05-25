<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-24
  Time: 下午2:04
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML comment -->

<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<%--<%@ include file="header.jsp"%>--%>
<jsp:include page="header.jsp"/>
<table>
    <tr>
        <th>------------------------</th>
    </tr>
    <%
//        request.getParameter("test");
//        test
        String c1 = "#9cf";
        String c2 = "#8c3";
        for (int i = 0; i < count; i++) {
            String c = (i % 2 == 0) ? c1 : c2;
            out.print("<tr bgcolor=\""+c+"\"</tr><td>------------------------</td></tr>");
        }
//        void method() {
//
//        }

    %>
</table>
<%!
    String getDate() {
    return new java.util.Date().toString();
    }

            int count = 10;

//    for (int i = 0; i < 10; i++) {
//
//    }
%>
<hr/>
当前的时间是：
<%-- JSP隐藏注释： 下面是表达式的例子...  JSTL --%>
<%="asdf"%>
</body>
</html>
