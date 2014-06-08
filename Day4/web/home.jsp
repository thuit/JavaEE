<%@ page import="java.sql.ResultSet" %>
<%@ page import="day4.demo.entity.Book" %>
<%@ page import="java.util.List" %>
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
<a href="user?action=logout">LOGOUT</a>
<hr/>
<h2>ADD BOOk</h2>
<form action="book" method="post">
    <input type="hidden" name="action" value="add">
    title <input name="title"><br>
    author <input name="author"><br>
    press <input name="press"><br>
    picture<input type="file" name="picture"><br>
    date <input name="date" value="2014-1-2"><br>
    price <input name="price" value="123.45"><br>
    amount <input name="amount" value="123"><br>
    <input type="submit" value="ADD">
</form>
<hr/>
<h2>BOOK LIST</h2>JSTL
<%
    List<Book> books = (List<Book>) session.getAttribute("books");
    for (Book book : books) {
        out.print("title:" + book.getTitle() + "<br>");
    }
%>
</body>
</html>
