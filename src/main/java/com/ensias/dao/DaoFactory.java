package com.ensias.dao;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
	private static final String PROPERTIES_FILE = "/mysql.properties";
	private static final String PROPERTY_URL ="url";
	private static final String PROPERTY_DRIVER ="driver";
	private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD    = "password";
	private String url;
	private String username;
	private String password;
	private static DaoFactory instance = null ;
	
	private DaoFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
	}
    
	
	 /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
	
	 public static DaoFactory getInstance() throws DAOConfigurationException {
		 if(instance == null) {
			 Properties properties = new Properties();
		        String url;
		        String driver;
		        String nomUtilisateur;
		        String motDePasse;

		        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		        InputStream fichierProperties = classLoader.getResourceAsStream( PROPERTIES_FILE );

		        if ( fichierProperties == null ) {
		            throw new DAOConfigurationException( "Le fichier properties " + PROPERTIES_FILE + " est introuvable." );
		        }

		        try {
		            properties.load( fichierProperties );
		            url = properties.getProperty( PROPERTY_URL );
		            driver = properties.getProperty( PROPERTY_DRIVER );
		            nomUtilisateur = properties.getProperty( PROPERTY_USERNAME );
		            motDePasse = properties.getProperty( PROPERTY_PASSWORD );
		        } catch ( IOException e ) {
		            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + PROPERTIES_FILE, e );
		        }

		        try {
		            Class.forName( driver );
		        } catch ( ClassNotFoundException e ) {
		            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
		        }
		        

		       instance = new DaoFactory( url, nomUtilisateur, motDePasse );
		 }
	        
	        return instance;
	    }
	 
	 /* Méthode chargée de fournir une connexion à la base de données */
	 
     public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }
    
    public DAOUser getDaoUser() {
    	return new DAOUser(this);
    }
    
    public ModuleDao getModuleDao() {
    	return new ModuleDao(this);
    }
    public DaoEvent getDaoEvent() {
    	return new DaoEvent(this);
    }
    
    public DAOTodo getDaoTodo() {
    	return new DAOTodo(this);
    }
}
