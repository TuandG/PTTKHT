<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/2/2024
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh Sách Tài Liệu</title>
    <script src="../../script/main.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        .table-container {
            border: 1px solid #ddd;
            width: 80%;
            max-width: 800px;
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .table-container th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
            padding: 12px;
        }

        .table-container td {
            border-top: 1px solid #ddd;
            padding: 12px;
        }

        .table-container tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .table-container tr:hover {
            background-color: #f1f1f1;
        }

        .back-button, .view-button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .back-button {
            background-color: #e57373;
            color: white;
            margin-top: 20px;
        }

        .back-button:hover {
            background-color: #d32f2f;
        }

        .view-button {
            background-color: #007bff;
            color: white;
        }

        .view-button:hover {
            background-color: #0056b3;
        }

        .button-container {
            display: flex;
            justify-content: flex-end;
        }
    </style>
</head>
<body>

<h1>Danh sách phiếu mượn</h1>
<c:choose>
    <c:when test="${sessionScope.get('danhSachPhieuMuon') != null}">
        <table class="table-container">
            <tr>
                <th>Mã phiếu mượn</th>
                <th>Ngày mươn</th>
                <th>Hạn mượn</th>
                <th>Hành động</th>
            </tr>
            <c:forEach items="${sessionScope.get('danhSachPhieuMuon')}" var="x" varStatus="status">
                <tr>
                    <td>${x.getId()}</td>
                    <td>${x.getNgayMuon()}</td>
                    <td>${x.getHanMuon()}</td>
                    <td>
                        <form action="/libman/chi-tiet-phieu-muon" method="post">
                            <input type="hidden" name="index" value="${status.index}"/>
                            <button class="view-button">Xem chi tiết</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4"></td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <%response.sendRedirect("/libman/view/quanly/gdDanhSachDocGiaTheoSoLanMuon766.jsp");%>
    </c:otherwise>
</c:choose>
<form action='/libman/view/quanly/gdDanhSachDocGiaTheoSoLanMuon766.jsp' method="get" class="button-container">
    <button class="back-button">Quay lại</button>
</form>

</body>
</html>
