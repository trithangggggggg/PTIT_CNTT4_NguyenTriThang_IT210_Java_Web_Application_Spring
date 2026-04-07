<%--
  Created by IntelliJ IDEA.
  User: ROG
  Date: 4/7/2026
  Time: 7:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhân viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }

        h2 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 85%;
        }

        th, td {
            border: 1px solid #999;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        .high {
            color: green;
            font-weight: bold;
        }

        .basic {
            color: blue;
        }
    </style>
</head>
<body>

<h2>Danh sách nhân viên phòng Đào tạo</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Họ và tên</th>
        <th>Phòng ban</th>
        <th>Lương</th>
        <th>Đánh giá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <c:choose>
                    <c:when test="${emp.salary >= 10000}">
                        <span class="high">Mức lương cao</span>
                    </c:when>
                    <c:otherwise>
                        <span class="basic">Mức lương cơ bản</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>