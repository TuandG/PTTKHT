<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/23/2024
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tìm kiếm tài liệu</title>
    <script src="../../script/main.js">
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #d3d3d3;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            width: 100%;
            align-items: center;
            justify-content: center;
            display: flex;
        }

        .search-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 20px;
            position: relative;
            width: 400px;
        }

        .search-input {
            width: 100%;
            padding: 10px 35px 10px 20px;
            border-radius: 25px;
            border: 1px solid #ccc;
            font-size: 16px;
            outline: none;
        }

        .search-button {
            position: absolute;
            right: 10px;
            background: none;
            border: none;
            cursor: pointer;
            font-size: 16px;
            color: #333;
        }

        .table-container {
            border: 1px solid #000;
            width: 400px;
            text-align: center;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .table-container th,
        .table-container td {
            border: 1px solid #000;
            padding: 15px;
        }

        .back-button {
            background-color: #e57373;
            color: white;
            padding: 10px 30px;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
        }

        .back-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>

<div class="search-container">
    <h1>Tìm kiếm tài liệu</h1>
    <form action="/libman/tim-kiem-tai-lieu" method="post">
        <input type="text" name="ten" class="search-input" placeholder="Nhập tên sách ở đây">
        <button class="search-button">&#128269;</button>
    </form>
</div>

<button class="back-button" onclick="quayLai()">Quay lại</button>

</body>
</html>

