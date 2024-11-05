<%@ page import="com.example.libman.model.TaiLieu766" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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

<h1>Danh Sách Tài Liệu</h1>
<c:choose>
  <c:when test="${sessionScope.get('taiLieus') != null}">
    <table class="table-container">
    <tr>
      <th>Mã tài liệu</th>
      <th>Tên tài liệu</th>
      <th>Tác giả</th>
      <th>Thể loại</th>
      <th>Hành động</th>
    </tr>
    <c:forEach items="${sessionScope.get('taiLieus')}" var="x" varStatus="status">
      <tr>
        <td>${x.getId()}</td>
        <td>${x.getTen()}</td>
        <td>${x.getTenTacGia()}</td>
        <td>${x.getTenTheLoai()}</td>
        <td>
          <form action="view/bandoc/gdChiTietTaiLieu766.jsp" method="get">
            <input type="hidden" name="index" value="${status.index}"/>
            <button class="view-button">Xem</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="5"></td>
    </tr>
    </table>
  </c:when>
  <c:otherwise>
    <%response.sendRedirect("gdTimKiemTaiLieu766.jsp");%>
  </c:otherwise>
</c:choose>
<form action='view/bandoc/gdTimKiemTaiLieu766.jsp' method="get" class="button-container">
  <button class="back-button">Quay lại</button>
</form>

</body>
</html>
