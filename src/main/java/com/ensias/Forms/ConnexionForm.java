package com.ensias.Forms;

import com.ensias.beans.User;
import com.ensias.dao.DAOUser;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ConnexionForm {
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASSWORD = "password";
    private String resultat;
    private Map<String,String> errors = new HashMap<>();
    private DAOUser daoUser = null;
    private User user = null;
    public ConnexionForm(DAOUser dao){
    	daoUser = dao;
    }
    public Map<String, String> getErrors() {
        return errors;
    }
    
    public User inscrireUtilisateur(HttpServletRequest request){
        String email = getValeurChamp(request,CHAMP_EMAIL);
        String password = getValeurChamp(request,CHAMP_PASSWORD);
        
        User utilisateur = new User();
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
        utilisateur.setPassword( password );

        try {
            validationMotsDePasse( utilisateur );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASSWORD, e.getMessage());
        }
        
        if ( errors.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        if(user ==null || !errors.isEmpty()) return utilisateur;
        utilisateur = null;
        return user;
        
    }
    private String getValeurChamp(HttpServletRequest request,String champ){
        String valeur = request.getParameter(champ);
        if(valeur ==null || valeur.trim().length()==0) return null;
        return valeur.trim();

    }

    //Methode de validation d'email
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.equals("null") ) {
            user = this.daoUser.findUser(email);
            if(user==null) {
            	throw new Exception( "Email introuvable.");
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    // Methode de validation de mot de passe
    private void validationMotsDePasse( User utilisateur) throws Exception {
    	String motDePasse = utilisateur.getPassword();
        if ( motDePasse != null && !motDePasse.trim().equals("null") ) {
            if(user !=null && !utilisateur.getPasswordAsHash().equals(user.getPassword())) throw new Exception( "Mot de passe invalide." );
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }


    private void setErreur( String champ, String message ) {
        errors.put( champ, message );
    }

    public String getResultat() {
        return resultat;
    }
}
