<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Đăng nhập</h2>
<form action="LoginServlet" method="post">
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
</form>
<font color="red">${error}</font>
<a href="register.jsp">Đăng ký</a>
</body>
</html>
