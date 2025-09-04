<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<style>
    body { font-family: Arial, sans-serif; background: #f9f9f9; }
    h2 { text-align: center; margin: 20px 0; }
    table {
        width: 80%; margin: 20px auto;
        border-collapse: collapse; background: #fff;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    th, td {
        border: 1px solid #ddd; padding: 10px; text-align: center;
    }
    th { background: #4CAF50; color: white; }
    tr:nth-child(even) { background: #f2f2f2; }
    .actions a {
        text-decoration: none; padding: 6px 12px;
        border-radius: 4px; margin: 0 4px;
        font-size: 14px; color: white;
    }
    .edit { background: #2196F3; }
    .delete { background: #f44336; }
    .add-btn {
        display: block; width: 150px; margin: 20px auto;
        text-align: center; background: #4CAF50; color: white;
        padding: 10px; border-radius: 5px; text-decoration: none;
    }
</style>
</head>
<body>
    <h2>Danh sách Category</h2>

    <a href="${pageContext.request.contextPath}/admin/insert" class="add-btn">+ Thêm Category</a>

    <table>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Tên Category</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${listcate}" var="cate" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${cate.id}</td>
                <td>${cate.categoryname}</td>
                <td class="actions">
                    <a href="${pageContext.request.contextPath}/admin/edit?id=${cate.id}" class="edit">Sửa</a>
                    <a href="${pageContext.request.contextPath}/admin/delete?id=${cate.id}" class="delete"
                       onclick="return confirm('Bạn có chắc muốn xóa không?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
