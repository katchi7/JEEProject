<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>

<html>
<head>
    <title>ENSIAS-DOC</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="/inc/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" type="text/css" href="/inc/styles/style_inscription.css">
    <link rel="stylesheet" type="text/css" href="/inc/styles/style_home.css">
    <link rel="icon" href="/inc/icons/logo.ico">
</head>
<body>
<c:import url="/WEB-INF/header.jsp"></c:import>
<div class="row">
  <div class="col-2 menu-gauche">
      <center>
          <svg xmlns="http://www.w3.org/2000/svg" width="60%" height="141.747" viewBox="0 0 153 141.747" style="margin-bottom: 10px;margin-top: 5%;">
              <path id="user-circle-solid" d="M76.5,8C34.24,8,0,39.722,0,78.874s34.24,70.874,76.5,70.874S153,118.026,153,78.874,118.76,8,76.5,8Zm0,27.435c14.992,0,27.145,11.26,27.145,25.149S91.492,85.732,76.5,85.732,49.355,74.473,49.355,60.584,61.508,35.435,76.5,35.435Zm0,98.309a61.1,61.1,0,0,1-45.191-19.49,34.812,34.812,0,0,1,30.384-17.09,8.1,8.1,0,0,1,2.19.314,41.346,41.346,0,0,0,25.233,0,8.1,8.1,0,0,1,2.19-.314,34.812,34.812,0,0,1,30.384,17.09A61.1,61.1,0,0,1,76.5,133.744Z" transform="translate(0 -8)" fill="rgba(0,0,0,0.52)"/>
          </svg>
          <p><h2>User Name</h2></p>
      </center>
        
      <nav class ="navbar menu-gauche-centre" >
          
        
            <div class="col-lg-12 col-md-12 col-sm-12 menu-centre on">
              <a class ="nav-link" href="#"> <i class="fab fa-leanpub"></i> Module </a>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 menu-centre">
              <a class ="nav-link" href="#"> <i class="fas fa-calendar-alt"></i> Clendrier </a>
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
              <div class="container corps_home">
                  <center>
                      <img src="/inc/images/logo.png" alt="ENSIAS-DOC" width="340" style="margin-bottom: 20px;"><br/>
                      <img src="/inc/images/learning.jpg" alt="ENSIAS-DOC" width="100%" height="400" style="margin-bottom: 60px;">
                      <img src="/inc/images/rechercher-logo.png" alt="ENSIAS-DOC" width="100" style="margin-bottom: 20px;margin-right:0px;">
                      <img src="/inc/images/rechercher.png" alt="ENSIAS-DOC" width="340" style="margin-bottom: 20px;margin-left:0px;">
                      <div class="input-group" style="width: 50%;">
                          <input type="search" class="form-control rounded" placeholder="Recherche module" aria-label="Search"
                            aria-describedby="search-addon" />
                          <button type="button" class="btn btn-outline-primary">Rechercher</button>
                      </div>
                      
                  </center>
              </div>
              <div class ="container align-self-center">
                  <div class="row justify-content-center">
                      <div class="col-lg-3 col-md-6 col-sm-12 carte">
                          <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                              <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 1</div>
                              <div class="card-body">
                                <h5 class="card-title">Titre module</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <div class="card-footer bg-transparent border-dark"><center><a href="#" class="btn btn-primary">Accéder</a></center></div>
                              </div>
                          </div>
                      </div>
                      <div class="col-lg-3 col-md-6 col-sm-12 carte">
                          <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                              <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 2</div>
                              <div class="card-body">
                                <h5 class="card-title">Titre module</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <div class="card-footer bg-transparent border-dark"><center><a href="#" class="btn btn-primary">Accéder</a></center></div>
                              </div>
                          </div>
                      </div>
                      <div class="col-lg-3 col-md-6 col-sm-12 carte">
                          <div class="card bg-light mb-3" style="max-width: 18rem;">
                              <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 3</div>
                              <div class="card-body">
                                <h5 class="card-title">Titre module</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <div class="card-footer bg-transparent border-secondary"><center><a href="#" class="btn btn-primary">Accéder</a></center></div>
                              </div>
                          </div>
                      </div>
                      <div class="col-lg-3 col-md-6 col-sm-12 carte">
                          <div class="card text-white bg-warning mb-3" style="max-width: 18rem;">
                              <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 4</div>
                              <div class="card-body">
                                <h5 class="card-title">Titre module</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <div class="card-footer bg-transparent border-secondary"><center><a href="#" class="btn btn-primary">Accéder</a></center></div>
                              </div>
                          </div>
                      </div>
                      <div class="col-lg-3 col-md-6 col-sm-12 carte">
                          <div class="card text-white bg-info mb-3" style="max-width: 18rem;">
                              <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 5</div>
                              <div class="card-body">
                                <h5 class="card-title">Titre module</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <div class="card-footer bg-transparent border-secondary"><center><a href="#" class="btn btn-primary">Accéder</a></center></div>
                              </div>
                          </div>
                      </div>
                      <div class="col-lg-3 col-md-6 col-sm-12 carte">
                          <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                              <div class="card-header"><i class="far fa-bookmark" style="margin-right: 7px;"></i>Module 6</div>
                              <div class="card-body">
                                <h5 class="card-title">Titre module</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <div class="card-footer bg-transparent border-secondary"><center><a href="#" class="btn btn-primary">Accéder</a></center></div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
              <nav aria-label="Page navigation example">
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
          </div>
      </div>
    
</section>
</div>

</div>
<c:import url="/WEB-INF/footer.jsp"></c:import>
</body>
</html>