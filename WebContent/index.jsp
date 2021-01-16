<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ENSIAS-DOC</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="inc/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css" integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css" integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous"/>
<<<<<<< HEAD
    <link rel="stylesheet" href="inc/style.css">
=======
    <link rel="stylesheet" href="inc/styles/style_index.css">
>>>>>>> 463592f... eclipse
    <link rel="icon" href="inc/icons/logo.ico">
  </head>
  <body>
    
    <div>
      <header>
        <nav class="navbar">
          <div class="container">
            <a class="navbar-brand" href="/"><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="200"></a>
              <%if(session.getAttribute("user")==null){%>
            <div>
              <a class="btn btn-outline-primary mr-2" href="login"><span><i class="fas fa-user"></i></span>&nbsp;&nbsp;Log In</a>
              <a class="btn btn-primary" href="register"><span><i class="fas fa-user-plus"></i></span>&nbsp;&nbsp;Sign Up</a></div>
          </div>
            <!--Si l'utilisateur est conecté-->
            <%}else{%>
            <div>
                <span><i class="fas fa-user-circle"></i> </span><strong><!--Activate when database is instanciated ${sessionScope.user.fname} ${sessionScope.user.lname}--> Aabane Abderrahim</strong>
                <a class="btn btn-danger" href="logout"><span><i class="fas fa-sign-out-alt"></i></span>&nbsp;&nbsp;Logout</a></div>
            </div>
            <%}%>
        </nav>
      </header>
    
      <section class="py-5 overflow-hidden"><div class="container py-5">
          <div class="row">
            <div class="position-relative col-12 col-lg-6 order-last order-lg-first mt-5 mt-lg-0"><img class="img-fluid position-relative mx-auto rounded w-100" style="z-index:10" src="inc/images/education.jpg" alt=""><img class="img-fluid position-absolute" width="160" height="160" style="top:0; left:0; margin-left: -48px; margin-top: -48px;" src="metis-assets/elements/blob-tear.svg" alt=""><img class="img-fluid position-absolute" width="160" height="160" style="right:0; bottom:0; margin-right: -48px; margin-bottom: -48px;" src="metis-assets/elements/blob-tear.svg" alt=""></div>
            <div class="col-12 col-lg-6 py-5">
              <div class="row">
                <div class="col-12 col-lg-8 mx-auto">
                  <span class="badge rounded-pill bg-primary">ENSIAS-DOC</span>
                  <h2 class="mt-3 mb-5 fw-bold">Connect&eacute; &agrave; votre avenir</h2>
                  <div class="d-flex mb-4 pb-1">
                    <span class="mr-4 text-primary">
                      <svg width="32" height="32" fill="none" stroke="currentColor" viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 9l3 3-3 3m5 0h3M5 20h14a2 2 0 002-2V6a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"></path></svg></span>
                    <div>
                      <h5>Tendance collaborative</h5>
                      <p class="mb-0 text-muted lh-lg">C'est tout ce dont vous avez besoin pour vous aider à vivre des expériences de travail d'équipe productives et enrichissantes!</p>
                    </div>
                  </div>
                  <div class="d-flex mb-4 pb-1">
                    <span class="mr-4 text-primary">
                      <svg width="32" height="32" fill="none" stroke="currentColor" viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 5a1 1 0 011-1h14a1 1 0 011 1v2a1 1 0 01-1 1H5a1 1 0 01-1-1V5zM4 13a1 1 0 011-1h6a1 1 0 011 1v6a1 1 0 01-1 1H5a1 1 0 01-1-1v-6zM16 13a1 1 0 011-1h2a1 1 0 011 1v6a1 1 0 01-1 1h-2a1 1 0 01-1-1v-6z"></path></svg></span>
                    <div>
                      <h5>Flexibilit&eacute; dans l&rsquo;apprentissage</h5>
                      <p class="mb-0 text-muted lh-lg">Optimisez vos efforts d'apprentissage avec une organisation confortable d'emploi du temps</p>
                    </div>
                  </div>
                  <div class="d-flex">
                    <span class="mr-4 text-primary">
                      <svg width="32" height="32" fill="none" stroke="currentColor" viewbox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 7a2 2 0 012 2m4 0a6 6 0 01-7.743 5.743L11 17H9v2H7v2H4a1 1 0 01-1-1v-2.586a1 1 0 01.293-.707l5.964-5.964A6 6 0 1121 9z"></path></svg></span>
                    <div>
                      <h5>Meilleur acc&egrave;s pour toutes les ressources p&eacute;dagogiques</h5>
                      <p class="mb-0 text-muted lh-lg">Parcourez vos cours et pr&eacute;parez vos examens en toute simplicit&eacute;</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
    

    <section class="page-section bg-light" id="team">
      <div class="container equipe">
          <div class="text-center">
              <h2 class="section-heading text-uppercase">Notre équipe</h2>
          </div>
          <div class="row">
              <div class="col-lg-3">
                  <div class="team-member">
                      <img class="mx-auto rounded-circle" src="inc/images/1.jpg" alt="" />
                      <h4>Aarab Oussama</h4>
                      <p class="text-muted"></p>
                      <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-google"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="https://www.facebook.com/Oussama.Aarab.07"><i class="fab fa-facebook-f"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/oussama-aarab/"><i class="fab fa-linkedin-in"></i></a>
                  </div>
              </div>
              <div class="col-lg-3">
                  <div class="team-member">
                      <img class="mx-auto rounded-circle" src="inc/images/2.jpg" alt="" />
                      <h4>Aabane Abderrahim</h4>
                      <p class="text-muted"></p>
                      <a class="btn btn-dark btn-social mx-2" href="mailto:abderrahim-aabane@um5.ac.ma"><i class="fab fa-google"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="https://www.facebook.com/abderrahim.ronaldox"><i class="fab fa-facebook-f"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/abderrahim-aabane-680b80195/"><i class="fab fa-linkedin-in"></i></a>
                  </div>
              </div>
              <div class="col-lg-3">
                  <div class="team-member">
                      <img class="mx-auto rounded-circle" src="inc/images/3.jpg" alt="" />
                      <h4>Anfar Asmaa</h4>
                      <p class="text-muted"></p>
                      <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-google"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="https://www.facebook.com/asmae.ar.35"><i class="fab fa-facebook-f"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/asmaa-anfar-00482b197/"><i class="fab fa-linkedin-in"></i></a>
                  </div>
              </div>
              <div class="col-lg-3">
                  <div class="team-member">
                      <img class="mx-auto rounded-circle" src="inc/images/4.jpg" alt="" />
                      <h4>Loumedene Salma</h4>
                      <p class="text-muted"></p>
                      <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-google"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                      <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                  </div>
              </div>
          </div>
      </div>
  </section>
  
    <footer id="sticky-footer" class="py-4 bg-dark text-white-50">
      <div class="container text-center">
        <small>Copyright &copy; 2021 <br> ENSIAS-DOC</small>
      </div>
    </footer>
    <script src="inc/js/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="inc/js/main.js"></script>
  </body>
</html>
