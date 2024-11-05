<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.libman.model.TaiLieu766" %>
<%@ page import="com.example.libman.utils.ServletUtils" %>
<%
    String index = ServletUtils.getParameter(request.getParameter("index"), String.class);
    Object taiLieus = session.getAttribute("danhSachTaiLieu");
    TaiLieu766 taiLieu = null;
    if(index != null && taiLieus != null && !((ArrayList<TaiLieu766>) taiLieus).isEmpty()) {
        taiLieu = ((ArrayList<TaiLieu766>) taiLieus).get(Integer.parseInt(index));
    } else {
        response.sendRedirect("/view/bandoc/gdTimKiemTaiLieu.jsp");
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tài liệu</title>
    <style>
        /* Tổng thể trang */
        body {
            font-family: Arial, sans-serif;
            background-color: #e0e0e0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            padding: 20px;
        }

        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        /* Bảng */
        .table-container {
            width: 80%;
            max-width: 600px;
            border-collapse: collapse;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .table-container th,
        .table-container td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: left;
        }

        .table-container th {
            background-color: #f5f5f5;
            font-weight: bold;
            text-align: center;
        }

        /* Nút */
        .button-container {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            gap: 20px;
        }

        .back-button,
        .read-button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            color: white;
            transition: background-color 0.3s;
        }

        .back-button {
            background-color: #e57373;
        }

        .back-button:hover {
            background-color: #d32f2f;
        }

        .read-button {
            background-color: #1976d2;
        }

        .read-button:hover {
            background-color: #0d47a1;
        }
    </style>
</head>
<body>

<h1>Tài liệu</h1>

<table class="table-container">
    <tr>
        <th>Mã tài liệu</th>
        <td><%=taiLieu.getId()%></td>
    </tr>
    <tr>
        <th>Tên tài liệu</th>
        <td><%=taiLieu.getTen()%></td>
    </tr>
    <tr>
        <th>Tác giả</th>
        <td><%=taiLieu.getTenTacGia()%></td>
    </tr>
    <tr>
        <th>Năm xuất bản</th>
        <td><%=taiLieu.getNgayXuatBan()%></td>
    </tr>
    <tr>
        <th>Số lượng</th>
        <td><%=taiLieu.getSoLuong()%></td>
    </tr>
    <tr>
        <th>Thể loại</th>
        <td><%=taiLieu.getTenTheLoai()%></td>
    </tr>
    <tr>
        <th>Mô tả</th>
        <td><%=taiLieu.getMoTa()%></td>
    </tr>
</table>

<form method="get" action="/libman/view/bandoc/gdDanhSachTaiLieu766.jsp">
    <div class="button-container">
        <button class="back-button">Quay lại</button>
    </div>
</form>
</body>
</html>
