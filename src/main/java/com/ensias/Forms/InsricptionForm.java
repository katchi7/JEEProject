package com.ensias.Forms;

import beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class InsricptionForm {
    private static final String CHAMP_NOM = "lname";
    private static final String CHAMP_PRENOM = "fname";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASSWORD = "fname";
    private String resultat;
    private Map<String,String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public User inscrireUtilisateur(HttpServletRequest request){
        String email = getValeurChamp(request,CHAMP_EMAIL);
        String nom = getValeurChamp(request,CHAMP_NOM);
        String password = getValeurChamp(request,CHAMP_PASSWORD);
        String prenom = getValeurChamp(request,CHAMP_PRENOM);
        User utilisateur = new User();
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        try {
            validationMotsDePasse( password );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASSWORD, e.getMessage() );
        }
        utilisateur.setPassword( password );

        try {
            validationNom(nom);
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setLname( nom );

        try {
            validationNom(prenom);
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setFname( prenom );


        if ( errors.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return utilisateur;
    }
    private String getValeurChamp(HttpServletRequest request,String champ){
        String valeur = request.getParameter(champ);
        if(valeur ==null || valeur.trim().length()==0) return null;
        return valeur.trim();

    }

    //Methode de validation d'email
    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    // Methode de validation de mot de passe
    private void validationMotsDePasse( String motDePasse) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }
    //Methode de validation du nom et prenom
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }


    private void setErreur( String champ, String message ) {
        errors.put( champ, message );
    }

    public String getResultat() {
        return resultat;
    }
}
