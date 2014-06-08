<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-6-8
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>EDIT BOOK</h1>
<form action="book" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${sessionScope.book.id}">
    title <input name="title" value="${sessionScope.book.title}"><br>
    author <input name="author" value="${sessionScope.book.author}"><br>
    press <input name="press" value="${sessionScope.book.press}"><br>
    picture<input type="file" name="picture" value="${sessionScope.book.picture}"><br>
    date <input name="date" value="${sessionScope.book.date}"><br>
    price <input name="price" value="${sessionScope.book.price}"><br>
    amount <input name="amount" value="${sessionScope.book.amount}"><br>
    <input type="submit" value="SAVE">
</form>
</body>
</html>
