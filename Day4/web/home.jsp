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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>home page</title>
    <script>
        function del() {
            return confirm("DEL?");
        }
    </script>
</head>
<body>
<c:if test="${sessionScope.username eq null}">
    <c:redirect url="index.jsp" />
</c:if>
<h1>HOME page</h1>
${sessionScope.username}
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
<h2>BOOK LIST</h2>
<table border="1">
    <c:choose>
        <c:when test="${sessionScope.books[0] eq null}">
            NO RECORD.
        </c:when>
        <c:otherwise>
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>AUTHOR</th>
                <th>PRESS</th>
                <th>PICTURE</th>
                <th>DATE</th>
                <th>PRICE</th>
                <th>AMOUNT</th>
                <th colspan="2">OPERATION</th>
            </tr>
        </c:otherwise>
    </c:choose>
    <c:forEach var="book" items="${sessionScope.books}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>${book.picture}</td>
            <td>${book.date}</td>
            <td>${book.price}</td>
            <td>${book.amount}</td>
            <td><a href="book?action=search&id=${book.id}">EDIT</a></td>
            <td><a href="book?action=remove&id=${book.id}" onclick="return del()">REMOVE</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
