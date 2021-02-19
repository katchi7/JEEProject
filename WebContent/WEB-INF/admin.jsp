<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ensias.beans.Module" %>
<%@ page import="com.ensias.beans.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>ENSIAS-DOC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="inc/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/duotone.css"
    integrity="sha384-R3QzTxyukP03CMqKFe0ssp5wUvBPEyy9ZspCB+Y01fEjhMwcXixTyeot+S40+AjZ" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/fontawesome.css"
    integrity="sha384-eHoocPgXsiuZh+Yy6+7DsKAerLXyJmu2Hadh4QYyt+8v86geixVYwFqUvMU8X90l" crossorigin="anonymous" />
  <link rel="stylesheet" type="text/css" href="/inc/styles/core.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style.css">
  <link rel="stylesheet" href="/inc/styles/style_inscription.css">
  <link rel="stylesheet" type="text/css" href="/inc/styles/style_admin.css">
  <link rel="stylesheet" href="/inc/styles/style_home.css">
  <link rel="stylesheet" href="/inc/styles/style_barre.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.4/js/tether.min.js"></script>

  <link rel="icon" href="/inc/icons/logo.ico">
</head>


<body>

  <div id="wrapper">
    <div class="overlay"></div>

    <!-- Sidebar -->
    <nav class="navbar navbar-inverse fixed-top" id="sidebar-wrapper" role="navigation" style="margin-top: 75px;">

      <ul class="nav sidebar-nav" style="list-style-type: none;">
        <div class="sidebar-header">
          <div class="sidebar-brand">
            <a href="#">${sessionScope.user.fname } ${sessionScope.user.lname }</a>
          </div>
        </div>
        <li><a href="/ensiasdocs/home">Module</a></li>
        <li><a href="/ensiasdocs/profile">Profile</a></li>
        <li><a href="/ensiasdocs/calendrier">Calendrier</a></li>
        <li><a href="#">To Do</a></li>
        <li><a href="">Administrateur</a></li>
        </li>
      </ul>
      <a class="navbar-brand" href=""><img src="/inc/images/logo.png" alt="ENSIAS-DOC" width="200"
          style="position: absolute;bottom: 100px;"></a>
    </nav>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <c:import url="/WEB-INF/header.jsp"></c:import>

      <div class="container align-self-center" style="margin-top: 140px;">
        <div class="min-vh-100">

          <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'Module')">Création d'un module</button>
            <button class="tablinks" onclick="openCity(event, 'Document')">Ajout des documents</button>
            <button class="tablinks" onclick="openCity(event, 'Modification')">Modification d'un
              module</button>
          </div>


          <!-- Page Modification module -->
          <div id="Modification" class="tabcontent">
            <h2>Modification d'un module</h2>
            <div>
              <form action="#" method="POST">
                <div class="row align-items-center">

                  <div class="input-group col-lg-12 mb-4">
                    <div class="input-group col-lg-12 mb-4" style="margin-top: 50px;">
                      <select id="cmodule" value="" name="cmodule"
                        class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Choix du module</option>
                        <option value="M1">Module 1</option>
                        <option value="M2">Module 2</option>
                        <option value="M3">Module 3</option>
                        <option value="M4">Module 4</option>
                        <option value="M5">Module 5</option>
                        <option value="M6">Module 5</option>
                      </select>
                    </div>

                    <!-- Nom module -->
                    <div class="input-group col-lg-12 mb-4">
                      <input type="text" name="nv_module" id="nv_module" class="form-control champs-form"
                        placeholder="Nouveau nom du module">
                    </div>

                    <!-- Année -->
                    <div class="input-group col-lg-6 mb-4">
                      <select id="nv_annee" value="" name="nv_annee"
                        class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Niveau d'étude</option>
                        <option value="1A">1er année</option>
                        <option value="2A">2ème année</option>
                        <option value="3A">3ème année</option>
                      </select>
                    </div>

                    <!-- Semestre -->
                    <div class="input-group col-lg-6 mb-4">
                      <select id="nv_semestre" value="" name="semestre"
                        class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Semestre</option>
                        <option value="S1">Semestre 1</option>
                        <option value="S2">Semestre 2</option>
                        <option value="S3">Semestre 3</option>
                        <option value="S4">Semestre 4</option>
                        <option value="S5">Semestre 5</option>
                      </select>
                    </div>

                    <!-- Description module -->
                    <div class="input-group col-lg-12 mb-4">
                      <textarea id="nv_dscModule" name="nv_dscModule" class="form-control md-textarea" length="120"
                        rows="3" placeholder="Description du module"></textarea>
                    </div>

                    <!-- Choix des filières -->
                    <div class="form-check">
                      <div class="input-group col-lg-12 mb-4 custom-control custom-checkbox">
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Génie Logiciel
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie du Web et Informatique Mobile
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          e-Management et Business Intelligence
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Sécurité des Systèmes d'Information
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie des Systèmes Embarqués, Mobiles
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie e-Logistique
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie Intélligence Artificielle
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie Digitale pour la Finance
                        </label>
                      </div>

                    </div>

                  </div>
                  <div class="form-group col-lg-12 mx-auto mb-0" >
                    <button class="btn btn-primary btn-block py-2 rounded" type="submit" style="margin-bottom: 30px;">
                      <span class="font-weight-bold">Créer un module</span>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>


          <!-- Page Création des modules -->
          <div id="Module" class="tabcontent">
            <h2>Création d'un module</h2>
            <div class="row py-5 align-items-center">
              <div>
                <form action="#" method="POST">
                  <div class="row">

                    <!-- Nom module -->
                    <div class="input-group col-lg-12 mb-4">
                      <input type="text" name="module" id="module" class="form-control champs-form"
                        placeholder="Nom du module">
                    </div>

                    <!-- Année -->
                    <div class="input-group col-lg-6 mb-4">
                      <select id="annee" value="" name="annee" class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Niveau d'étude</option>
                        <option value="1A">1er année</option>
                        <option value="2A">2ème année</option>
                        <option value="3A">3ème année</option>
                      </select>
                    </div>

                    <!-- Semestre -->
                    <div class="input-group col-lg-6 mb-4">
                      <select id="semestre" value="" name="semestre"
                        class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Semestre</option>
                        <option value="S1">Semestre 1</option>
                        <option value="S2">Semestre 2</option>
                        <option value="S3">Semestre 3</option>
                        <option value="S4">Semestre 4</option>
                        <option value="S5">Semestre 5</option>
                      </select>
                    </div>
                    <!-- Description module -->
                    <div class="input-group col-lg-12 mb-4">
                      <textarea id="dscModule" name="dscModule" class="form-control md-textarea" length="120" rows="3"
                        placeholder="Description du module"></textarea>
                    </div>



                    <!-- Choix des filières -->
                    <div class="form-check">
                      <div class="input-group col-lg-12 mb-4 custom-control custom-checkbox">
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Génie Logiciel
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie du Web et Informatique Mobile
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          e-Management et Business Intelligence
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Sécurité des Systèmes d'Information
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie des Systèmes Embarqués, Mobiles
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie e-Logistique
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie Intélligence Artificielle
                        </label>
                        <label class="container">
                          <input type="checkbox">
                          <span class="checkmark"></span>
                          Ingénierie Digitale pour la Finance
                        </label>
                      </div>
                    </div>

                    <!-- Submit Button -->
                    <div class="form-group col-lg-12 mx-auto mb-0">
                      <button class="btn btn-primary btn-block py-2 rounded" type="submit">
                        <span class="font-weight-bold">Créer un module</span>
                      </button>
                    </div>

                  </div>
                </form>
              </div>
            </div>
          </div>



          <div id="Document" class="tabcontent">
            <h2>Ajout des documents</h2>
            <div>
              <form action="#" method="POST">
                <div class="row align-items-center">

                  <div class="input-group col-lg-12 mb-4">
                    <div class="input-group col-lg-12 mb-4" style="margin-top: 50px;">
                      <select id="nom_module" value="" name="nom_module"
                        class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Choix du module</option>
                        <option value="M1">Module 1</option>
                        <option value="M2">Module 2</option>
                        <option value="M3">Module 3</option>
                        <option value="M4">Module 4</option>
                        <option value="M5">Module 5</option>
                        <option value="M6">Module 5</option>
                      </select>
                    </div>

                    <!-- Année -->
                    <div class="input-group col-lg-12 mb-4">
                      <select id="doc_annee" value="" name="doc_annee"
                        class="browser-default custom-select champs-form choix">
                        <option value="" disabled selected>Niveau d'étude</option>
                        <option value="1A">1er année</option>
                        <option value="2A">2ème année</option>
                        <option value="3A">3ème année</option>
                      </select>
                    </div>

                    <div class="container">
                      <div class="row it">

                        <div class="col-sm-offset-1 col-sm-10" id="one" style="margin-left: 50px;padding: 50px;">

                          <!--row-->
                          <div id="uploader">
                            <div class="row uploadDoc">
                              <div class="col-sm-3">
                                <div class="docErr">Please upload valid file</div>
                                <!--error-->
                                <div class="fileUpload btn btn-orange">
                                  <img src="https://image.flaticon.com/icons/svg/136/136549.svg" class="icon">
                                  <span class="upl" id="upload">Upload document</span>
                                  <input type="file" class="upload up" id="up" onchange="readURL(this);" />
                                </div><!-- btn-orange -->
                              </div><!-- col-3 -->
                              <div class="col-sm-8">
                                <input type="text" class="form-control" name="" placeholder="Note">
                              </div>
                              <!--col-8-->
                              <div class="col-sm-1 align-items-center" ><a class="btn-check"><i class="fa fa-times"></i></a></div>
                              <!-- col-1 -->
                            </div>
                            <!--row-->
                          </div>
                          <!--uploader-->
                          <div class="text-center">
                            <a class="btn btn-new"><i class="fa fa-plus"></i> Ajouter </a>
                            <a class="btn btn-next"><i class="fa fa-paper-plane"></i> Enregistrer</a>
                          </div>
                        </div>
                        <!--one-->

                      </div><!-- container -->

                    </div>
                  </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <c:import url="/WEB-INF/footer.jsp"></c:import>
    </div>
    <!-- /#page-content-wrapper -->
  </div>

  <script src="/inc/js/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="/inc/js/main.js"></script>
  <script src="/inc/js/barre.js"></script>
  <script src="/inc/js/admin.js"></script>
  <script src="/inc/js/upload.js"></script>
</body>

</html>