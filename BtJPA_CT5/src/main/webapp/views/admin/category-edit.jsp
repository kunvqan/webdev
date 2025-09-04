<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Category</title>
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
        background: #2196F3; color: white;
        border: none; border-radius: 5px;
        font-size: 16px; cursor: pointer;
    }
    button:hover { background: #1976D2; }
    .back-link {
        display: block; text-align: center; margin-top: 15px;
        text-decoration: none; color: #2196F3;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h2>Sửa Category</h2>
        <form action="${pageContext.request.contextPath}/admin/edit" method="post">
            <input type="hidden" name="id" value="${cate.id}">
            <label>Tên Category:</label>
            <input type="text" name="categoryname" value="${cate.categoryname}" required>
            <button type="submit">Cập nhật</button>
        </form>
        <a href="${pageContext.request.contextPath}/admin/categories" class="back-link">← Quay lại danh sách</a>
    </div>
</body>
</html>
