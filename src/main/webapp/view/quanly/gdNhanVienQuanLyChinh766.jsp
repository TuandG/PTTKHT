<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/2/2024
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #d3d3d3; /* Màu nền xám */
        }

        h1 {
            color: #333;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .button-container {
            background-color: #8fd19e; /* Màu xanh nhạt */
            color: #333;
            padding: 10px 30px;
            border: none;
            border-radius: 25px;
            font-size: 18px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .button-container:hover {
            background-color: #7dc48b;
        }
    </style>
</head>
<body>
<h1>Trang Chủ</h1>
<a href="gdXemThongKe766.jsp" class="button-container">Xem thống kê</a>
</body>
</html>