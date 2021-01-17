package bdd;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;


public class Test {
	public List<User> recupererUsers(){
		List<User> users = new ArrayList<User>();
		/* Chargement du driver JDBC pour MySQL */
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les éventuelles erreurs ici. */
		}
		/* Connexion à la base de données */
		
		String url = "jdbc:mysql://localhost:3306/projbdd";
		String utilisateur = "java";
		String motDePasse = "SdZ_eE";
		
		Connection connexion = null; // cnx a la base 
		Statement statement = null;  //rqt sql
		ResultSet resultat = null;
		
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		    
		    statement = (Statement) connexion.createStatement();
		    
		    resultat = ((java.sql.Statement) statement).executeQuery("SELECT email, password, lname, fname FROM Test;");

		   while(resultat.next()) {
			   String email =resultat.getString("email");
			   String password =resultat.getString("password");
			   String lname =resultat.getString("lname");
			   String fname =resultat.getString("fname");
			   int id= resultat.getInt("id");
			   
			   User user = new User();
			   user.setEmail(email);
			   user.setFname(fname);
			   user.setId(id);
			   user.setPassword(password);
			   user.setLname(lname);
			   
			   users.add(user);
		   }
		} catch ( SQLException e ) {
		} finally {
			try {
				if ( connexion != null )
					connexion.close();
				if ( statement != null )
					((java.sql.Statement) statement).close();
				if ( resultat != null )
					resultat.close();
		}catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}
		return users;
	}
}
