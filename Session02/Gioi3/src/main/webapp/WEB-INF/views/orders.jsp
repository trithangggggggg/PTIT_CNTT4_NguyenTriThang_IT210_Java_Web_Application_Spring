<%--
  Created by IntelliJ IDEA.
  User: ROG
  Date: 4/7/2026
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>

<h1>Danh sách đơn hàng</h1>

<p>
    Xin chào, <strong><c:out value="${sessionScope.loggedUser}" /></strong>!
    Vai trò: <strong><c:out value="${sessionScope.role}" /></strong>
</p>

<p>
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</p>

<table border="1" cellpadding="6" cellspacing="0">
    <tr>
        <th>STT</th>
        <th>Mã đơn</th>
        <th>Tên sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>

    <c:forEach var="order" items="${requestScope.orders}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td><c:out value="${order.orderCode}" /></td>
            <td><c:out value="${order.productName}" /></td>
            <td>
                <fmt:formatNumber value="${order.totalAmount}" type="number" groupingUsed="true" />
                VNĐ
            </td>
            <td>
                <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy" />
            </td>
        </tr>
    </c:forEach>
</table>

<br/>

<p>
    Tổng lượt xem đơn hàng toàn hệ thống:
    <strong>${applicationScope.totalViewCount.get()}</strong>
</p>

</body>
</html>