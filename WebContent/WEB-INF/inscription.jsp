<%@ page import="com.ensias.Forms.InsricptionForm" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <a class="navbar-brand" href="/"><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="200"></a>
            <div>
                <a class="btn btn-outline-primary mr-2" href="login"><span><i class="fas fa-user"></i></span>&nbsp;&nbsp;Log In</a>
                <a class="btn btn-primary" href="register"><span><i class="fas fa-user-plus"></i></span>&nbsp;&nbsp;Sign Up</a></div>
            </div>
        </nav>
    </header>
    <% if(request.getAttribute("form")==null || (!((InsricptionForm)request.getAttribute("form")).getErrors().isEmpty())) {%>
    <div class="principal">
        <div class="container">
            <div class="row py-5 mt-4 align-items-center">
            
                <div class="col-md-5 pr-lg-5 mb-5 mb-md-0" >
                    <p class="logo"><a><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="400" alt="ENSIAS-DOC" class="img-fluid mb-3 d-md-block"></a></p>
                    <img src="https://res.cloudinary.com/mhmd/image/upload/v1569543678/form_d9sh6m.svg" alt="" class="img-fluid mb-3 d-none d-md-block">
                    <h1>Créer votre compte</h1>

                </div>
				
                <div class="col-md-7 col-lg-6 ml-auto">
                    <form action="register" method = "POST">
                        <div class="row">

                            <!-- Prénom -->
                            <c:choose>
                            <c:when test="${requestScope.form.errors.prenom==null}">
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-user text-muted"></i>
                                    </span>
                                </div>
                                <input id="prenom" type="text" name="prenom" value = "${requestScope.user.fname}" placeholder="Prénom" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            </c:when>
                            <c:otherwise>
                            <div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-user text-muted err"></i>
                                    </span>
                                </div>
                                <input id="prenom" type="text" name="prenom" value = "${requestScope.user.fname}" placeholder="Prénom" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            </c:otherwise>
                            </c:choose>
                            

                            <!-- Nom -->
                            <c:choose>
                            	<c:when test="${requestScope.form.errors.nom==null}">
                            	<div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-user text-muted"></i>
                                    </span>
                                </div>
                                <input id="nom" type="text" name="nom" value = "${requestScope.user.lname}" placeholder="Nom" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            	</c:when>
                            	<c:otherwise>
                            	<div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-user text-muted err"></i>
                                    </span>
                                </div>
                                <input id="nom" type="text" name="nom" placeholder="Nom" value = "${requestScope.user.lname}" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            	</c:otherwise>
                            </c:choose>
                            

                            <!-- Adresse email -->
                            <c:choose>
                            	<c:when test="${requestScope.form.errors.email==null}">
                            	<div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-envelope text-muted"></i>
                                    </span>
                                </div>
                                <input id="email" type="email" value = "${requestScope.user.email}" name="email" placeholder="Adresse Email" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            	</c:when>
                            	<c:otherwise>
                            	<div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-envelope text-muted err"></i>
                                    </span>
                                </div>
                                <input id="email" type="email" name="email" value = "${requestScope.user.email}" placeholder="Adresse Email" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            	</c:otherwise>
                            </c:choose>
                            

                            <!-- Numéro de téléphone -->
                            <c:choose>
                            	<c:when test="${requestScope.form.errors.phone==null}">
                            	<div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-phone-square text-muted"></i>
                                    </span>
                                </div>
                                <input id="phone" type="tel" name="phone" value = "${requestScope.user.num}" placeholder="Numéro de téléphone" class="form-control bg-white border-md border-left-0 pl-3 champs-form">
                            </div>.
                            	</c:when>
                            	<c:otherwise>
                            	<div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fa fa-phone-square text-muted err"></i>
                                    </span>
                                </div>
                                <input id="phone" type="tel" name="phone" value = "${requestScope.user.num}" placeholder="Numéro de téléphone" class="form-control bg-white border-md border-left-0 pl-3 champs-form">
                            </div>.
                            	</c:otherwise>
                            </c:choose>
                            


                            <!-- Niveau d'étude -->
                            <c:choose>
                            	<c:when test="${requestScope.form.errors.niveau==null}">
                            	 <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fas fa-graduation-cap text-muted"></i>
                                    </span>
                                </div>
                                <select id="niveau" value = "${requestScope.user.niveau}" name="niveau" class="form-control custom-select bg-white border-left-0 border-md champs-form">
                                    <option value="" disabled ${(requestScope.user.niveau==null)?"selected":""}>Niveau d'étude</option>
                                    <option value="1A" ${(requestScope.user.niveau=="1A")?"selected":""}>1er année</option>
                                    <option value="2A" ${(requestScope.user.niveau=="2A")?"selected":""}>2ème année</option>
                                    <option value="3A" ${(requestScope.user.niveau=="3A")?"selected":""}>3ème année</option>
                                </select>
                            </div>
                            	</c:when>
                            	<c:otherwise>
                            	<div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="fas fa-graduation-cap text-muted err"></i>
                                    </span>
                                </div>
                                <select id="niveau" name="niveau" value = "${requestScope.user.niveau}" class="form-control custom-select bg-white border-left-0 border-md champs-form">
                                    <option value="" disabled ${(requestScope.user.niveau==null)?"selected":""}>Niveau d'étude</option>
                                    <option value="1A" ${(requestScope.user.niveau=="1A")?"selected":""}>1er année</option>
                                    <option value="2A" ${(requestScope.user.niveau=="2A")?"selected":""}>2ème année</option>
                                    <option value="3A" ${(requestScope.user.niveau=="3A")?"selected":""}>3ème année</option>
                                </select>
                            </div>
                            	</c:otherwise>
                            </c:choose>
                           

                            <!-- Filière -->
                            <c:choose>
                            <c:when test="${requestScope.form.errors.filiere==null}">
                            	 <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="far fa-map text-muted"></i>
                                    </span>
                                </div>
                                <select id="filiere" name="filiere" value = "${requestScope.user.filiere}" class="form-control custom-select bg-white border-left-0 border-md champs-form">
                                    <option value="" disabled ${requestScope.user.filiere==null?"selected":""}>Choix du filière</option>
                                    <option value="GL" ${requestScope.user.filiere=="GL"?"selected":""}>Génie Logiciel</option>
                                    <option value="IWIM" ${requestScope.user.filiere=="IWIM"?"selected":""}>Ingénierie du Web et Informatique Mobile</option>
                                    <option value="eMBI" ${requestScope.user.filiere=="eMBI"?"selected":""}>e-Management et Business Intelligence</option>
                                    <option value="SSI" ${requestScope.user.filiere=="SSI"?"selected":""}>Sécurité des Systèmes d'Information</option>
                                    <option value="ISEM" ${requestScope.user.filiere=="ISEM"?"selected":""}>Ingénierie des Systèmes Embarqués, Mobiles</option>
                                    <option value="IeL" ${requestScope.user.filiere=="IeL"?"selected":""}>Ingénierie e-Logistique</option>
                                    <option value="2IA" ${requestScope.user.filiere=="2IA"?"selected":""}>Ingénierie Intélligence Artificielle</option>
                                    <option value="IF" ${requestScope.user.filiere=="IF"?"selected":""}>Ingénierie Digitale pour la Finance</option>
                                </select>
                                </div>
                                </c:when>
                                <c:otherwise>
                                <div class="input-group col-lg-12 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        <i class="far fa-map text-muted err"></i>
                                    </span>
                                </div>
                                <select id="filiere" name="filiere" value = "${requestScope.user.filiere}" class="form-control custom-select bg-white border-left-0 border-md champs-form">
                                    <option value="" disabled ${requestScope.user.filiere==null?"selected":""}>Choix du filière</option>
                                    <option value="GL" ${requestScope.user.filiere=="GL"?"selected":""}>Génie Logiciel</option>
                                    <option value="IWIM" ${requestScope.user.filiere=="IWIM"?"selected":""}>Ingénierie du Web et Informatique Mobile</option>
                                    <option value="eMBI" ${requestScope.user.filiere=="eMBI"?"selected":""}>e-Management et Business Intelligence</option>
                                    <option value="SSI" ${requestScope.user.filiere=="SSI"?"selected":""}>Sécurité des Systèmes d'Information</option>
                                    <option value="ISEM" ${requestScope.user.filiere=="ISEM"?"selected":""}>Ingénierie des Systèmes Embarqués, Mobiles</option>
                                    <option value="IeL" ${requestScope.user.filiere=="IeL"?"selected":""}>Ingénierie e-Logistique</option>
                                    <option value="2IA" ${requestScope.user.filiere=="2IA"?"selected":""}>Ingénierie Intélligence Artificielle</option>
                                    <option value="IF" ${requestScope.user.filiere=="IF"?"selected":""}>Ingénierie Digitale pour la Finance</option>
                                </select>
                                </div>
                                </c:otherwise>
                            
                            </c:choose>
                           

                            <!-- Mot de passe -->
                            <c:choose>
                            	<c:when test="${requestScope.form.errors.password==null}">
                            	<div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    		<span class="input-group-text bg-white px-4 border-md border-right-0 icones-form">
                                        		<i class="fa fa-lock text-muted"></i>
                                    		</span>
                                		</div>
                                			<input id="password" type="password" value = "${requestScope.user.password}" name="password" placeholder="Mot de passe" class="form-control bg-white border-left-0 border-md champs-form">
                            		</div>
                            	</c:when>
                            	
                            	<c:otherwise>
                            	<div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form ">
                                        <i class="fa fa-lock text-muted err" ></i>
                                    </span>
                                </div>
                                <input id="password" type="password" name="password" value = "${requestScope.user.password}" placeholder="Mot de passe" class="form-control bg-white border-left-0 border-md champs-form">
                            </div>
                            	</c:otherwise>
                            </c:choose>
                            

                            <!-- Confiramation du mot de passe -->
                            
							<c:choose>
								<c:when test="${requestScope.form.errors.passwordConfirmation==null}">
								<div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form ">
                                        <i class="fa fa-lock text-muted"></i>
                                    </span>
                                </div>
                                <input id="passwordConfirmation" type="password" name="passwordConfirmation" placeholder="Confirmation du mot de passe" class="form-control bg-white border-left-0 border-md champs-form ">
                            	
                            </div>
								</c:when>
								<c:otherwise>
								<div class="input-group col-lg-6 mb-4">
                                <div class="input-group-prepend">
                                    <span class="input-group-text bg-white px-4 border-md border-right-0 icones-form ">
                                        <i class="fa fa-lock text-muted err"></i>
                                    </span>
                                </div>
                                <input id="passwordConfirmation" type="password" name="passwordConfirmation" placeholder="Confirmation du mot de passe" class="form-control bg-white border-left-0 border-md champs-form ">
                            	
                            </div>
								</c:otherwise>
							</c:choose>
                            
					<!-- Submit Button -->
                            <div class="form-group col-lg-12 mx-auto mb-0">
                                <button class="btn btn-primary btn-block py-2 rounded" type = "submit">
                                    <span class="font-weight-bold">Créer un compte</span>
                                </button>
                            </div>
                            <!-- Already Registered -->
                            <div class="text-center w-100">
                                <p class="text-muted font-weight-bold">Vous avez déjà un compte ? <a href="#" class="text-primary ml-2">Login</a></p>
                            </div>

                        </div>
                    </form>
                </div>
                <%}else{ %>
                    <div class="principal">
                        <div class="container">
                            <div class="row py-5 mt-4 align-items-center">
                            
                                <div class="col-md-5 pr-lg-5 mb-5 mb-md-0" >
                                    <p class="logo"><a><img src="inc/images/logo.png" alt="ENSIAS-DOC" width="400" alt="ENSIAS-DOC" class="img-fluid mb-3 d-md-block"></a></p>
                                    <img src="inc/images/study.png" alt="" class="img-fluid mb-3 d-none d-md-block">
                                </div>
                
                                <div class="col-md-7 col-lg-6 ml-auto">
                                    <h2>Bonjour chère ${user.lname} ${user.fname},</h2><br/>
                                    <p class="first-connect">Bienvenue dans votre espace étudiant, vous faites maintenant parti de la famille <span class="first-connect">ENSIAS-DOC</span>. Afin d'accéder à votre compte et de 
                                        bénéficier d'une expérience inédite dans l'e-learning, veuillez se connecter en cliquant sur le boutton ci-dessous.
                                    </p>
                                    <a href="login" class="btn btn-success btn-lg active" role="button" title="Lien 1">Se connecter</a>
                                </div>
                            </div>
                        </div>
                    </div>
                <%} %>
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