<%@ page import="com.ensias.Forms.InsricptionForm" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ENSIAS-DOC</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="inc/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" type="text/css" href="inc/styles/style_inscription.css">
    <link rel="icon" href="inc/icons/logo.ico">
</head>
<body>

    <header class="header">
        <nav class="navbar">
            <div class="container">
            <a class="navbar-brand" href="index.jsp"><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="200"></a>
            <div>
                <a class="btn btn-outline-primary mr-2" href="#"><span><i class="fas fa-user"></i></span>&nbsp;&nbsp;Log In</a>
                <a class="btn btn-primary" href="#"><span><i class="fas fa-user-plus"></i></span>&nbsp;&nbsp;Sign Up</a></div>
            </div>
        </nav>
    </header>

    <div class="principal">
        <div class="container">
            <div class="row py-5 mt-4 align-items-center">
            
                <div class="col-md-5 pr-lg-5 mb-5 mb-md-0" >
                    <p class="logo"><a><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="400" alt="ENSIAS-DOC" class="img-fluid mb-3 d-md-block"></a></p>
                    <img src="https://res.cloudinary.com/mhmd/image/upload/v1569543678/form_d9sh6m.svg" alt="" class="img-fluid mb-3 d-none d-md-block">
                    <h1>Créer votre compte</h1>

                </div>

                <div class="col-md-7 col-lg-6 ml-auto">
                    <form action="#">
                        <div class="row">

                            <!-- Prénom -->
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-user text-muted"></i>
                                    </span>
                                </div>
                                <input id="prenom" type="text" name="prenom" placeholder="Prénom" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>

                            <!-- Nom -->
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-user text-muted"></i>
                                    </span>
                                </div>
                                <input id="nom" type="text" name="nom" placeholder="Nom" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>

                            <!-- Adresse email -->
                            <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-envelope text-muted"></i>
                                    </span>
                                </div>
                                <input id="email" type="email" name="email" placeholder="Adresse Email" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>

                            <!-- Numéro de téléphone -->
                            <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-phone-square text-muted"></i>
                                    </span>
                                </div>
                                <input id="phone" type="tel" name="phone" placeholder="Numéro de téléphone" class="form-control bg-white border-md border-left-0 pl-3 champs-form">
                            </div>.


                            <!-- Niveau d'étude -->
                            <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fas fa-graduation-cap text-muted"></i>
                                    </span>
                                </div>
                                <select id="niveau" name="niveau" class="form-control custom-select bg-white border-left-0 border-md champs-form">
                                    <option value="" disabled selected>Niveau d'étude</option>
                                    <option value="1A">1er année</option>
                                    <option value="2A">2ème année</option>
                                    <option value="3A">3ème année</option>
                                </select>
                            </div>

                            <!-- Filière -->
                            <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="far fa-map text-muted"></i>
                                    </span>
                                </div>
                                <select id="filiere" name="filiere" class="form-control custom-select bg-white border-left-0 border-md champs-form">
                                    <option value="" disabled selected>Choix du filière</option>
                                    <option value="GL">Génie Logiciel</option>
                                    <option value="IWIM">Ingénierie du Web et Informatique Mobile</option>
                                    <option value="eMBI">e-Management et Business Intelligence</option>
                                    <option value="SSI">Sécurité des Systèmes d'Information</option>
                                    <option value="ISEM">Ingénierie des Systèmes Embarqués, Mobiles</option>
                                    <option value="IeL">Ingénierie e-Logistique</option>
                                    <option value="2IA">Ingénierie Intélligence Artificielle</option>
                                    <option value="IF">Ingénierie Digitale pour la Finance</option>
                                </select>
                            </div>

                            <!-- Mot de passe -->
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-lock text-muted"></i>
                                    </span>
                                </div>
                                <input id="password" type="password" name="password" placeholder="Mot de passe" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>

                            <!-- Confiramation du mot de passe -->
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-lock text-muted"></i>
                                    </span>
                                </div>
                                <input id="passwordConfirmation" type="text" name="passwordConfirmation" placeholder="Confirmation du mot de passe" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>

                            <!-- Submit Button -->
                            <div class="form-group col-lg-12 mx-auto mb-0">
                                <a href="#" class="btn btn-primary btn-block py-2 rounded">
                                    <span class="font-weight-bold">Créer un compte</span>
                                </a>
                            </div>

                            <!-- Already Registered -->
                            <div class="text-center w-100">
                                <p class="text-muted font-weight-bold">Vous avez déjà un compte ? <a href="#" class="text-primary ml-2">Login</a></p>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <footer id="sticky-footer" class="py-4 bg-dark text-white-50">
        <div class="container text-center">
          <small>Copyright &copy; 2021 <br> ENSIAS-DOC</small>
        </div>
    </footer>

</body>
</html>