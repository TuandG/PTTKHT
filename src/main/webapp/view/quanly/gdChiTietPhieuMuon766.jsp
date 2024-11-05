<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi Tiết phiếu mượn</title>
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

<h1>Chi tiết phiếu mượn</h1>
<c:choose>
    <c:when test="${sessionScope.get('danhSachPhieuMuonTaiLieu') != null}">
        <table class="table-container">
            <tr>
                <th>Mã tài liệu</th>
                <th>Tên tài liệu</th>
                <th>Ngày trả</th>
            </tr>
            <c:forEach items="${sessionScope.get('danhSachPhieuMuonTaiLieu')}" var="x" varStatus="status">
                <tr>
                    <td>${x.getTaiLieu().getId()}</td>
                    <td>${x.getTaiLieu().getTen()}</td>
                    <c:choose>
                        <c:when test="${x.getNgayTra() == null}">
                            <td>Chưa trả</td>
                        </c:when>
                        <c:otherwise>
                            <td>${x.getNgayTra()}</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3"></td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <%response.sendRedirect("/libman/view/quanly/gdDanhSachPhieuMuonTheoDocGia766.jsp");%>
    </c:otherwise>
</c:choose>
<form action='/libman/view/quanly/gdDanhSachPhieuMuonTheoDocGia766.jsp' method="get" class="button-container">
    <button class="back-button">Quay lại</button>
</form>

</body>
</html>