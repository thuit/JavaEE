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
        session.setAttribute("username", "zhangsan");
//页面跳转1 重定向REDIRECT: a.地址栏发生改变 b.不能保存request范围内的属性
        response.sendRedirect("home.jsp");
//        request.getRequestDispatcher("home.jsp").forward(request, response);k
    } else {
        request.setAttribute("message", "用户名或密码错误");
//页面跳转2 转发FORWARD:    a.地址栏不变 b.可以保存request范围内的属性
        request.getRequestDispatcher("index.jsp").forward(request, response);
//        response.sendRedirect("index.jsp");
    }
%>
