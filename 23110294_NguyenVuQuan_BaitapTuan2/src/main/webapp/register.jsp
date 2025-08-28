<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Đăng ký</h2>
<form action="RegisterServlet" method="post">
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    Email: <input type="text" name="email"/><br/>
    <input type="submit" value="Register"/>
</form>
<font color="red">${error}</font>
</body>
</html>
