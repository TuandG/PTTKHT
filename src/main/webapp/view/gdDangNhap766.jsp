<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/2/2024
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
    <style>
        /* Đặt kiểu chung cho body */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
        }

        /* Tạo hộp chứa form */
        .login-container {
            background-color: #ffffff;
            padding: 20px 40px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 300px;
            text-align: center;
        }

        /* Tiêu đề */
        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Kiểu cho nhãn và input */
        label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }

        /* Thay đổi viền khi focus vào input */
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007bff;
            outline: none;
        }

        /* Nút đăng nhập */
        input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        /* Hiệu ứng hover cho nút */
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập</h2>
    <form action="/libman/dang-nhap" method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="tenDangNhap" required>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="matKhau" required>

        <input type="submit" value="Đăng nhập">
    </form>
</div>
</body>
</html>

