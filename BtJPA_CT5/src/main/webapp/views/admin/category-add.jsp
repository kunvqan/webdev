<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Category</title>
<style>
    body { font-family: Arial, sans-serif; background: #f9f9f9; }
    .form-container {
        width: 400px; margin: 50px auto; padding: 20px;
        background: #fff; border-radius: 8px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    h2 { text-align: center; margin-bottom: 20px; }
    label { display: block; margin-bottom: 8px; font-weight: bold; }
    input[type="text"] {
        width: 100%; padding: 8px; margin-bottom: 15px;
        border: 1px solid #ccc; border-radius: 4px;
    }
    button {
        width: 100%; padding: 10px;
        background: #4CAF50; color: white;
        border: none; border-radius: 5px;
        font-size: 16px; cursor: pointer;
    }
    button:hover { background: #45a049; }
    .back-link {
        display: block; text-align: center; margin-top: 15px;
        text-decoration: none; color: #2196F3;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h2>Thêm Category</h2>
        <form action="${pageContext.request.contextPath}/admin/insert" method="post">
            <label>Tên Category:</label>
            <input type="text" name="categoryname" required>
            <button type="submit">Thêm</button>
        </form>
        <a href="${pageContext.request.contextPath}/admin/categories" class="back-link">← Quay lại danh sách</a>
    </div>
</body>
</html>
