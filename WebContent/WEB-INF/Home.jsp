<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ensias.beans.Module"%>
<%@ page import="com.ensias.beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<% ArrayList<Module> modules =(ArrayList<Module>) request.getAttribute("modules"); %>
<!DOCTYPE html>
<html>
<head>
    <title>ENSIAS-DOC</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="/inc/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" type="text/css" href="/inc/styles/style_inscription.css">
    <link rel="icon" href="/inc/icons/logo.ico">
</head>
<body>
<c:import url="/WEB-INF/header.jsp"></c:import>
<div class ="container">
<c:forEach items ="${ modules }" var = "module">
<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${module.elm_name}</h5>
    <p class="card-text">${module.elm_module}</p>
    <a href="module/${module.elm_id}" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
</c:forEach>

</div>
<c:import url="/WEB-INF/footer.jsp"></c:import>
</body>
</html>