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
    <link rel="icon" href="logo.ico">
</head>
<body>

    <header class="header">
        <nav class="navbar">
            <div class="container">
            <a class="navbar-brand" href="/"><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="200"></a>
            <div>
                <a class="btn btn-outline-primary mr-2" href="login"><span><i class="fas fa-user"></i></span>&nbsp;&nbsp;Log In</a>
                <a class="btn btn-primary" href="register"><span><i class="fas fa-user-plus"></i></span>&nbsp;&nbsp;Sign Up</a></div>
            </div>
        </nav>
    </header>

    <div class="principal">
        <div class="container">
            <div class="row py-5 mt-4 align-items-center">
            
                <div class="col-md-5 pr-lg-5 mb-5 mb-md-0" >
                    <p class="logo"><a><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="400" alt="ENSIAS-DOC" class="img-fluid mb-3 d-md-block"></a></p>
                    <img src="inc/images/login.png" alt="" class="img-fluid mb-3 d-none d-md-block">
                    

                </div>

                <div class="col-md-7 col-lg-6 ml-auto">
                    <form action="#">
                        <div class="row">
                            <h1>Espace étudiant</h1><br/><br/><br/>
                            <!-- Adresse email -->
                            <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0">
                                        <i class="fa fa-envelope text-muted"></i>
                                    </span>
                                </div>
                                <input id="email" type="email" name="email" placeholder="Adresse Email" class="form-control bg-white border-left-0 border-md">
                            </div>

                            <!-- Mot de passe -->
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0">
                                        <i class="fa fa-lock text-muted"></i>
                                    </span>
                                </div>
                                <input id="password" type="password" name="password" placeholder="Mot de passe" class="form-control bg-white border-left-0 border-md">
                            </div>

                            <!-- Submit Button -->
                            <div class="form-group col-lg-12 mx-auto mb-0">
                                <a href="#" class="btn btn-primary btn-block py-2">
                                    <span class="font-weight-bold">Se connecter</span>
                                </a>
                            </div>
                            
                            <!-- Already Registered -->
                            <div class="text-center w-100">
                                <br/>
                                <p class="text-muted font-weight-bold">Mot de passe oublié ? <a href="#" class="text-primary ml-2">Password</a></p>
                                <p class="text-muted font-weight-bold">Créer un nouveau compte ? <a href="register" class="text-primary ml-2">Sign up</a></p>
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