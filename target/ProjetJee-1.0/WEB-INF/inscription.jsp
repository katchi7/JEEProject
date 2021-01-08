<%@ page import="com.ensias.Forms.InsricptionForm" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>
    Hello to the registring page
</h1>
<br/>
<% if(request.getAttribute("form")==null || (!((InsricptionForm)request.getAttribute("form")).getErrors().isEmpty())) {%>

<form method="post" action="register">

    <div>${requestScope.form.resultat}</div>
    <label>Nom : </label> <input type="text" name="lname" placeholder="Nom" value="${requestScope.user.lname}"> <span>${requestScope.form.errors.get("lname")}</span><br/>

    <label>Prenom : </label> <input type="text" name="fname" placeholder="Prenom" value="${requestScope.user.fname}"> <span>${requestScope.form.errors.get("fname")}</span><br/>
    <label>Email : </label> <input type="email" name="email" placeholder="Email" value="${requestScope.user.email}"> <span>${requestScope.form.errors.get("email")}</span><br/>
    <label>Password : </label> <input type="password" name="password" value="${requestScope.user.password}"> <span>${requestScope.form.errors.get("password")}</span><br/>
    <button type="submit">Register</button>
</form>

<%}else {%>
    <h2>You're registred as ${requestScope.user.fname} ${requestScope.user.lname}</h2>
<%}%>
</body>
</html>