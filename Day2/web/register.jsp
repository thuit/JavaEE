<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-25
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    String[] cities = request.getParameterValues("city");
    String[] hobbies = request.getParameterValues("hobbies");

//    DB

    response.sendRedirect("index.jsp");
%>