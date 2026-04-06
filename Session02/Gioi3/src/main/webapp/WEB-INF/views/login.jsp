<%--
  Created by IntelliJ IDEA.
  User: ROG
  Date: 4/7/2026
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>

<h1>Đăng nhập hệ thống</h1>

<c:if test="${not empty errorMessage}">
    <p style="color: red;">
        <c:out value="${errorMessage}" />
    </p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    <div>
        <label>Tên đăng nhập:</label>
        <input type="text" name="username" />
    </div>
    <br/>
    <div>
        <label>Mật khẩu:</label>
        <input type="password" name="password" />
    </div>
    <br/>
    <button type="submit">Đăng nhập</button>
</form>

<p>Tài khoản test:</p>
<ul>
    <li>admin / admin123</li>
    <li>staff / staff123</li>
</ul>

</body>
</html>