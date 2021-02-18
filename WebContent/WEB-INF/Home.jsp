<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ensias.beans.Module" %>
<%@ page import="com.ensias.beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ArrayList<Module> modules =(ArrayList<Module>) request.getAttribute("modules"); %>
<% String[] bgs=new String[]{"bg-success","bg-light","bg-warning","bg-info","bg-info","bg-dark"}; %>
<% String[] txt=new String[]{"","text-white"}; %>
<!DOCTYPE html>

<html>

<head>
  <title>ENSIAS-DOC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="/inc/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_inscription.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_home.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_module.css">
  <link rel="icon" href="/inc/icons/logo.ico">
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css"
    integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css"
    integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous" />
  <link rel="icon" href="/inc/icons/logo.ico">
</head>

<body>
  <c:import url="/WEB-INF/header.jsp"></c:import>
  <div class="row min-vh-100" style="width: 100%;">
    <div class="col-2 menu-gauche " style="min-height: 100%;">
      <center>
        <svg xmlns="http://www.w3.org/2000/svg" width="60%" height="141.747" viewBox="0 0 153 141.747"
          style="margin-bottom: 10px;margin-top: 5%;">
          <path id="user-circle-solid"
            d="M76.5,8C34.24,8,0,39.722,0,78.874s34.24,70.874,76.5,70.874S153,118.026,153,78.874,118.76,8,76.5,8Zm0,27.435c14.992,0,27.145,11.26,27.145,25.149S91.492,85.732,76.5,85.732,49.355,74.473,49.355,60.584,61.508,35.435,76.5,35.435Zm0,98.309a61.1,61.1,0,0,1-45.191-19.49,34.812,34.812,0,0,1,30.384-17.09,8.1,8.1,0,0,1,2.19.314,41.346,41.346,0,0,0,25.233,0,8.1,8.1,0,0,1,2.19-.314,34.812,34.812,0,0,1,30.384,17.09A61.1,61.1,0,0,1,76.5,133.744Z"
            transform="translate(0 -8)" fill="rgba(0,0,0,0.52)" />
        </svg>
        <p>
        <h2>${sessionScope.user.fname } ${sessionScope.user.lname }</h2>
        </p>
      </center>

      <nav class="navbar menu-gauche-centre ">
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre on">
          <a class="nav-link" href=""> <i class="fab fa-leanpub"></i> Module </a>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
          <a class="nav-link" href="/ensiasdocs/calendrier"> <i class="fas fa-calendar-alt"></i> Calendrier </a>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
          <a class="nav-link" href="/ensiasdocs/profile"> <i class="fas fa-user"></i> Profile </a>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
          <a class="nav-link" href="#"> <i class="fas fa-file-alt"></i> To Do </a>
        </div>
      </nav>
    </div>
    <div class="col-10 corps_globale">
      <div class="container corps_home">
        <div class="container align-self-center" >
          <div class="row justify-content-center">
        <center>
          <img src="/inc/images/logo.png" alt="ENSIAS-DOC" width="340" style="margin-bottom: 20px;"><br />
          <img class="image-learn" src="/inc/images/learning.jpg" alt="ENSIAS-DOC" width="100%" height="400">
          <img src="/inc/images/rechercher-logo.png" alt="ENSIAS-DOC" width="100"
            style="margin-bottom: 20px;margin-right:0px; ">
          <img class="image-recherche" src="/inc/images/rechercher.png" alt="ENSIAS-DOC" width="340">
          <div class="input-group recherche" style="width: 50%;box-shadow: 5px 5px 5px 5px grey;border-radius:30px;">
            <input type="search" class="form-control rounded" placeholder="Recherche module" aria-label="Search"
              aria-describedby="search-addon" />
            <button type="button" class="btn btn-outline-primary" style="border: none;">Rechercher</button>
          </div>

        </center>
      </div>

      <div class="container align-self-center">
        <div class="row justify-content-center" style="padding-top: 100px;">
          <% int i=0; %>
            <c:forEach items="${ modules }" var="module">
              <div class="col-lg-3 col-md-6 col-sm-12 carte">
                <div class="card  <%= i!=1?txt[1]:txt[0] %> <%= bgs[i%bgs.length] %> mb-3" style="max-width: 18rem;">
                  <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 1</div>
                  <div class="card-body">
                    <h5 class="card-title">${module.elm_name }</h5>
                    <p class="card-text">${module.elm_description }</p>
                    <div class="card-footer bg-transparent border-dark">
                      <center><a href="module/${module.elm_id}" class="btn btn-primary">Accéder</a>
                      </center>
                    </div>
                  </div>

                </div>
                <% i++; %>

              </div>
            </c:forEach>

        </div>
      </div>
    </div>
    <nav class="page-nbr" aria-label="Page navigation example">
      <ul class="pagination justify-content-center">
        <li class="page-item disabled">
          <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
          <a class="page-link" href="#">Next</a>
        </li>
      </ul>
    </nav>
  </div></div></div>


  <c:import url="/WEB-INF/footer.jsp"></c:import>
</body>

</html>