/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationxml;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author etudiant1
 */
public class Connection {
    
    public static String salle1;
    public static String salle2;
    public static String salle3;
    public static String salle4;
    public static String salle5;
    public static String salle6;
    public static String salle7;
    public static String salle8;
    public static String salle9;
    
    
    public static String salle12;
    public static String salle22;
    
    
    public static String salle01;
    
    
    public static String departementChoisie = FXMLDocumentController.Departement;
    public static String joursChoisie = FXMLDocumentController.Jours;
    public static String HeureChoisie = FXMLDocumentController.Crenaux;
   // static ObservableList oqp = FXCollections.observableArrayList();
   static String oqp;
    
    
 
 
    
    public static void lireEnBase() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		//String salle = "";
                ObservableList salle = FXCollections.observableArrayList();
                
                
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM "+departementChoisie+" WHERE etage='1'";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				if(!salle.equals(rs.getString("salle"))){

                         salle.add(rs.getString("salle"));
                     
        		}


				
			}
                        
                       salle1 = salle.get(0).toString();
                       salle2 = salle.get(1).toString();
                       salle3 = salle.get(2).toString();
                       salle4 = salle.get(3).toString();
                      salle5=salle.get(4).toString();
                      salle6=salle.get(5).toString();
                      salle7=salle.get(6).toString();  
                      salle8=salle.get(7).toString();
                      //salle9=salle.get(8).toString();
                        System.out.println(joursChoisie);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
                }
    }
    
	 public static void lireEnBase2() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		//String salle = "";
                ObservableList salle1 = FXCollections.observableArrayList();
                
                
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM "+departementChoisie+" WHERE etage='2'";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				if(!salle1.equals(rs.getString("salle"))){

                         salle1.add(rs.getString("salle"));
                     
        		}


				
			}
                        
                       salle12 = salle1.get(0).toString();
                       salle22 = salle1.get(1).toString();
                       
                      
                        System.out.println(joursChoisie);
                        System.out.println(salle22);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
                }
    }
    
public static void lireEnBase3() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		//String salle = "";
                ObservableList salle2 = FXCollections.observableArrayList();
                
                
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM "+departementChoisie+" WHERE etage='0'";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				if(!salle2.equals(rs.getString("salle"))){

                         salle2.add(rs.getString("salle"));
                     
        		}


				
			}
                        
                       salle01 = salle2.get(0).toString();
                       
                       
                      
                        System.out.println(joursChoisie);
                        System.out.println(salle01);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
                }
    }
public static void lireEnBaseAutredepartement() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		//String salle = "";
                ObservableList salle = FXCollections.observableArrayList();
                
                
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM "+departementChoisie+" ";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				if(!salle.equals(rs.getString("salle"))){

                         salle.add(rs.getString("salle"));
                     
        		}


				
			}
                        
                       salle1 = salle.get(0).toString();
                       salle2 = salle.get(1).toString();
                       salle3 = salle.get(2).toString();
                       salle4 = salle.get(3).toString();
                      salle5=salle.get(4).toString();
                      salle6=salle.get(5).toString();
                      
                        System.out.println(joursChoisie);
                        System.out.println(salle);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
                }
    }
}
	
