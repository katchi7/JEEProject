package com.ensias.Forms;

import com.ensias.beans.User;
import com.ensias.dao.DAOUser;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsricptionForm {
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_PRENOM = "prenom";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASSWORD = "password";
    private static final String CHAMP_PHONE = "phone";
    private static final String CHAMP_NV = "niveau";
    private static final String CHAMP_FILIERE = "filiere";
    private static final String CHAMP_CONFIRM_PASSWORD = "passwordConfirmation";
    
    private static final ArrayList<String> NIVEAUX = new ArrayList<String>();
    static {
    	NIVEAUX.add("1A");
    	NIVEAUX.add("2A");
    	NIVEAUX.add("3A");
    }
    private static final ArrayList<String> FILIERES = new ArrayList<String>();
    static {
    	FILIERES.add("GL");
    	FILIERES.add("IWIM");
    	FILIERES.add("eMBI");
    	FILIERES.add("Iel");
    	FILIERES.add("ISEM");
    	FILIERES.add("SSI");
    	FILIERES.add("2IA");
    	FILIERES.add("IF");
    }
    
    private String resultat;
    private Map<String,String> errors = new HashMap<>();
    private DAOUser daoUser;
    
    public InsricptionForm(DAOUser daoUser){
    	this.daoUser = daoUser;
    }
    
    public Map<String, String> getErrors() {
        return errors;
    }

    public User inscrireUtilisateur(HttpServletRequest request){
        String email = getValeurChamp(request,CHAMP_EMAIL);
        String nom = getValeurChamp(request,CHAMP_NOM);
        String password = getValeurChamp(request,CHAMP_PASSWORD);
        String prenom = getValeurChamp(request,CHAMP_PRENOM);
        String confirm_password = getValeurChamp(request,CHAMP_CONFIRM_PASSWORD);
        String filiere = getValeurChamp(request,CHAMP_FILIERE);
        String niveau = getValeurChamp(request,CHAMP_NV);
        String phone = getValeurChamp(request,CHAMP_PHONE);
        
        User utilisateur = new User();
        //Validation de l'email
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email.trim().toLowerCase() );
        
        try {
            validationMotsDePasse( password );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASSWORD, e.getMessage() );
        }
        try {
        	ConfirmMotDePasse(confirm_password,password);
        	utilisateur.setPassword( password );
        }catch(Exception e) {
        	setErreur(CHAMP_CONFIRM_PASSWORD,e.getMessage());
        	utilisateur.setPassword( null );
        }
        

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
        try {
            validationNum(phone);
        } catch ( Exception e ) {
            setErreur( CHAMP_PHONE, e.getMessage() );
        }
        utilisateur.setNum(phone);
        try {
            validationFiliere(filiere);
        } catch ( Exception e ) {
            setErreur( CHAMP_FILIERE, e.getMessage() );
        }
        utilisateur.setFiliere(filiere);
        try {
            validationNV(niveau);
        } catch ( Exception e ) {
            setErreur( CHAMP_NV, e.getMessage() );
        }
        utilisateur.setNiveau(niveau);
        
        if ( errors.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        
        if(this.getErrors().isEmpty()) this.daoUser.Create(utilisateur);
        return utilisateur;
    }
    private String getValeurChamp(HttpServletRequest request,String champ){
        String valeur = request.getParameter(champ);
        if(valeur ==null || valeur.trim().length()==0) return null;
        return valeur.trim();

    }

    //Methode de validation d'email
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.equals("null") ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }if(this.daoUser.findUser(email)!=null) {
            	throw new Exception( "Cette adresse existe deja." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    // Methode de validation de mot de passe
    private void validationMotsDePasse( String motDePasse) throws Exception {
        if ( motDePasse != null && !motDePasse.equals("null") ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }
    //Methode de validation du nom et prenom
    private void validationNom( String nom ) throws Exception {
        if ( nom == null || nom.equals("null") || nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }
    //Validateur Num
    public void validationNum(String num) throws Exception {
    	String patterns 
        = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
        + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
        + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
    	if((num != null)&&num.matches(patterns)) {
    		return;
    	}else {
    		throw new Exception("Vous devez rentrer un numero valide");
    	}
    }
    //validateur filiere
    public void validationFiliere(String filiere) throws Exception {
    	if(filiere == null && !filiere.equals("null")) {
    		throw new Exception("Vous devez choisir une filiere");
    	}if(!FILIERES.contains(filiere)) throw new Exception("Vous devez choisir une des filieres proposées");
    }
    //Confirmateur mot de passe
    public void  ConfirmMotDePasse(String confirmPassword,String Password) throws Exception{
    	if(confirmPassword!=null && !confirmPassword.equals("null")) {
    		if(confirmPassword.equals(Password)) {
    			return;
    		}else {
    			throw new Exception("Vous n'avez pas entré le meme mot de passe");
    		}
    	
    	}else {
    		throw new Exception("Vous devez entrer le mot de passe a nouveau");
    	}
    	
    }
    
    //Methode de validation du niveau
    public void validationNV(String NV) throws Exception {
    	if(NV == null && NV.equals("null")) {
    		throw new Exception("Vous devez choisir un niveau");
    	}if(!NIVEAUX.contains(NV)) throw new Exception("Vous devez choisir un des niveaux proposés");
    	 
    }


    private void setErreur( String champ, String message ) {
        errors.put( champ, message );
        
    }

    public String getResultat() {
        return resultat;
    }
    
    
}
