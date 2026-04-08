<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ROG
  Date: 4/8/2026
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thằng minh ngu</title>
</head>
<body>
<h1>Thằng Tiến  ngu</h1>
<c:forEach items="${listStudent}" var="s">
    <p> <c:out value="${s.name}"</p>

</c:forEach>
</body>
</html>
