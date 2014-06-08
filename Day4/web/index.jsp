<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h1>Day4...</h1>
<%
    out.print(request.getHeader("User-Agent"));
%>
<form action="user" method="post">
    <input type="hidden" name="action" value="login">
    username: <input name="username" value="zhangsan"><br>
    password: <input type="password" name="password" value="123"><br>
    <input type="submit" value="LOGIN"/>
</form>
<em style="color: #f00;">
    <%
    String message = (String) request.getAttribute("message");
    if (message != null) {
        out.print(message);
    }

//        session.setAttribute("key", "value");
//        out.print(session.getAttribute("key"));

%>
</em><br>
<a href="signup.jsp">Sign up</a>
<hr/>
<pre>
    表单提交的两种方式：
    1. get(form的method属性的默认值)  a. 地址栏有请求字符串 b. 请求字符串长度有限制
    2. post a. 没有请求字符串     b. 没有长度限制
    以链接(地址栏直接写地址)的方式发送的请求都是get请求
</pre>
</body>
</html>