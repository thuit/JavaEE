<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-5-25
  Time: 上午9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
//String [] strings = request.getParameterValues("");
//    DB
    if (username.equalsIgnoreCase("zhangsan") && password.equals("123")) {
//页面跳转1:
        response.sendRedirect("home.jsp");
    } else {
//页面跳转2:
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
