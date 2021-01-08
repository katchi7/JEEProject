<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>
    Hello to the registering page
</h1>
<br/>
<%if(session.getAttribute("user")==null){%>
<form method="post" action="login">

    <div>${requestScope.form.resultat}</div>
    <label>Email : </label> <input type="email" name="email" placeholder="Email" value="${requestScope.user.email}"> <span>${requestScope.form.errors.get("email")}</span><br/>
    <label>Password : </label> <input type="password" name="password" value="${requestScope.user.password}"> <span>${requestScope.form.errors.get("password")}</span><br/>
    <button type="submit">Register</button>
</form>
<%}%>
</body>
</html>