<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm độc giả</title>
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
            gap: 2rem;
            width: 100%;
            max-width: 800px;
            padding: 0 1rem;
        }

        .date-inputs {
            display: flex;
            justify-content: space-between;
            gap: 2rem;
        }

        .date-group {
            flex: 1;
        }

        .date-label {
            display: block;
            font-size: 1.25rem;
            margin-bottom: 0.5rem;
            color: #333;
        }

        .date-input {
            width: 100%;
            padding: 0.75rem;
            font-size: 1rem;
            border: none;
            border-radius: 2rem;
            background: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .buttons {
            display: flex;
            justify-content: center;
            gap: 1rem;
            margin-top: 1rem;
        }

        .search-button {
            background-color: #3498db;
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 2rem;
            cursor: pointer;
            font-size: 1rem;
            transition: background-color 0.2s;
        }

        .search-button:hover {
            background-color: #2980b9;
        }

        .back-button {
            background-color: #e74c3c;
            color: white;
            padding: 0.75rem 2rem;
            border: none;
            border-radius: 2rem;
            cursor: pointer;
            font-size: 1rem;
            transition: background-color 0.2s;
        }

        .back-button:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
<h1>Tìm kiếm độc giả theo thời gian</h1>
<form action="/libman/danh-sach-doc-gia-theo-so-lan-muon" method="post">
<div class="container">
    <c:if test="${requestScope.get('error') != null}">
        <span style="color: red;">* ${requestScope.get('error')}</span>
    </c:if>
    <div class="date-inputs">
        <div class="date-group">
            <label class="date-label">Bắt đầu</label>
            <input type="date" name="ngayMuon" class="date-input" value="<%=LocalDate.now().toString()%>">
        </div>
        <div class="date-group">
            <label class="date-label">Kết thúc</label>
            <input type="date" name="hanMuon" class="date-input" value="<%=LocalDate.now().toString()%>">
        </div>
    </div>
    <div class="buttons">
        <button type="submit" class="search-button">Tìm kiếm</button>
        <button onclick="history.back()" class="back-button">Quay lại</button>
    </div>
</div>
</form>
</body>
</html>
