<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Thống kê</title>
  <script src="../../script/main.js"></script>
  <style>
    body {
      margin: 0;
      min-height: 100vh;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      background-color: #e5e5e5;
      font-family: system-ui, -apple-system, sans-serif;
    }

    h1 {
      color: #333;
      margin-bottom: 2rem;
    }

    .container {
      display: flex;
      flex-direction: column;
      gap: 1.5rem;
      width: 100%;
      max-width: 400px;
      justify-content: center;
      align-items: center;
    }

    .stat-button {
      width: 100%;
      background-color: #98e5b0;
      color: #000;
      padding: 1rem;
      border: none;
      border-radius: 2rem;
      cursor: pointer;
      text-decoration: none;
      text-align: center;
      font-size: 1rem;
      transition: background-color 0.2s;
    }

    .stat-button:hover {
      background-color: #7ed498;
    }

    .back-button {
      background-color: #e74c3c;
      color: white;
      padding: 0.75rem 2rem;
      border: none;
      border-radius: 0.5rem;
      cursor: pointer;
      margin-top: 2rem;
      font-size: 1rem;
      transition: background-color 0.2s;
    }

    .back-button:hover {
      background-color: #c0392b;
    }
  </style>
</head>
<body>
<h1>Xem thống kê</h1>
<div class="container">
  <a href="/libman/view/quanly/gdThongKeDocGiaTheoSoLanMuon766.jsp" class="stat-button">
    Thống kê độc giả theo số lần mượn
  </a>
  <a href="#" class="stat-button">
    Thống kê tài liệu theo số lần mượn
  </a>
  <a href="#" class="stat-button">
    Thống kê nhà cung cấp theo tài liệu nhập
  </a>
  <button onclick="quayLai()" class="back-button">
    Quay lại
  </button>
</div>
</body>
</html>
