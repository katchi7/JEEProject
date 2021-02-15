<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ensias.beans.Module"%>
<%@ page import="com.ensias.beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css" integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css" integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous"/>

    <link rel="icon" href="logo.ico">
  </head>
    </head>
    <body>
        <c:import url="/WEB-INF/header.jsp"></c:import>

        <div class="row vh-100" style="width: 100%;">
            <div class="col-2 menu-gauche" style="height: 100%;">
              <center>
                <svg xmlns="http://www.w3.org/2000/svg" width="60%" height="141.747" viewBox="0 0 153 141.747" style="margin-bottom: 10px;margin-top: 5%;">
                  <path id="user-circle-solid" d="M76.5,8C34.24,8,0,39.722,0,78.874s34.24,70.874,76.5,70.874S153,118.026,153,78.874,118.76,8,76.5,8Zm0,27.435c14.992,0,27.145,11.26,27.145,25.149S91.492,85.732,76.5,85.732,49.355,74.473,49.355,60.584,61.508,35.435,76.5,35.435Zm0,98.309a61.1,61.1,0,0,1-45.191-19.49,34.812,34.812,0,0,1,30.384-17.09,8.1,8.1,0,0,1,2.19.314,41.346,41.346,0,0,0,25.233,0,8.1,8.1,0,0,1,2.19-.314,34.812,34.812,0,0,1,30.384,17.09A61.1,61.1,0,0,1,76.5,133.744Z" transform="translate(0 -8)" fill="rgba(0,0,0,0.52)"/>
                </svg>
                <p><h2>${sessionScope.user.fname } ${sessionScope.user.lname }</h2></p>
              </center>
                  
              <nav class ="navbar menu-gauche-centre" >                              
                <div class="col-lg-12 col-md-12 col-sm-12 menu-centre on">
                  <a class ="nav-link" href="#"> <i class="fab fa-leanpub"></i> Module </a>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
                  <a class ="nav-link" href="#"> <i class="fas fa-calendar-alt"></i> Calendrier </a>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
                  <a class ="nav-link" href="#"> <i class="fas fa-user"></i> Profile </a>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
                  <a class ="nav-link" href="#"> <i class="fas fa-file-alt"></i> To Do </a>
                </div>                                    
              </nav>
            </div>
            <div class="col-10 corps_globale">
              <div class ="container align-self-center">
                <div class="row justify-content-center">
                  <div class="col-lg-12 col-md-12 col-sm-12 carte module-name-bloc">
                    <div class="card text-white bg-light mb-3">
                        <center><div class="card-header module-name">${requestScope.module.elm_name}</div></center>
                    </div>
                  </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 carte">
                        <div class="card text-white bg-secondary mb-3">
                            <div class="card-header section-header"><i class="fas fa-graduation-cap" style="margin-right: 12px;"></i>Documets</div>
                            <div class="card-body">
                            <c:forEach items = "${ requestScope.types }" var = "type" >
                              <h5 class="type-title"><i class="fas fa-hand-point-right" style="margin-right: 7px;"></i>${type}</h5>
                              <c:forEach items = "${ requestScope.docs }" var = "doc" >
                              <div class="bloc-file">
                                <a class ="file-title" href="/ensiasdocs/document/${ doc.doc_id }"><i class="fas fa-file-pdf" style="margin-right: 7px;"></i>${ doc.doc_name}</a>
                                <div style="float:right;">
                                  <a href="/ensiasdocs/download/${ doc.doc_id }" ><button  class="button-show btn-telecharger"><i class="fa fa-download" style="margin-right: 5px;"></i><span>Télécharger </span></button></a>
                                  <a href="/ensiasdocs/document/${ doc.doc_id }" ><button class="button-show btn-visualiser"><i class="fas fa-eye" style="margin-right: 5px;"></i><span>Visualiser </span></button></a>
                                </div>
                              </div>
                              </c:forEach>
                             </c:forEach>
                            </div>
                        </div>
                    </div>
                 
              </div>
    
              
            </div>
          </div>
        </div>

        <c:import url="/WEB-INF/footer.jsp"></c:import>
    </body>
</html>