/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationxml;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



/**
 * FXML Controller class
 *
 * @author etudiant1
 */
public class AutredepartementFXMLController implements Initializable {

    static String Nombtnsalle;
    
    String oqp;
    String cours ;
    String oqp7;
    @FXML
    private AnchorPane pane2;
    @FXML
    private Button btn2;
    @FXML
    private Button btnsalle1;
    @FXML
    private Button btnsalle2;
    @FXML
    private Button btnsalle3;
    @FXML
    private Button btnsalle4;
    @FXML
    private Button btnsalle5;
    @FXML
    private Button btnsalle6;
    
    
    
    
     String salle1 = Connection.salle1;
     String salle2 = Connection.salle2;
     String salle3 = Connection.salle3;
     String salle4 = Connection.salle4;
     String salle5 = Connection.salle5;
     String salle6 = Connection.salle6;
     
     
     
     
      String Crenauxrecup = FXMLDocumentController.Crenaux ;
    String Departementrecup = FXMLDocumentController.Departement ;
    String Joursrecup = FXMLDocumentController.Jours ;
   
     @FXML
    private void btn1aff(ActionEvent event) throws IOException {

        Nombtnsalle = btnsalle1.getText();
       
        coco();
  }
        
    
    
    
    
    @FXML
    private void btn2aff(ActionEvent event) throws IOException {
    
   
   
        Nombtnsalle = btnsalle2.getText();
        coco();
    }
    
    @FXML
    private void btn3aff(ActionEvent event) throws IOException {
    
   
   
        Nombtnsalle = btnsalle3.getText();
        coco();
    }
    @FXML
    private void btn4aff(ActionEvent event) throws IOException {
    
   
   
        Nombtnsalle = btnsalle4.getText();
        coco();
    }
    @FXML
    private void btn5aff(ActionEvent event) throws IOException {
    
   
   
        Nombtnsalle = btnsalle5.getText();
        coco();
    }
    
    
    @FXML
    private void btn6aff(ActionEvent event) throws IOException {
    
   
   
        Nombtnsalle = btnsalle6.getText();
        coco();
    }
void coco(){
   
   
   String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		//String salle = "";
              
                
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+Nombtnsalle+"' AND heure='"+Crenauxrecup+"' ";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				

                         oqp = (rs.getString("status"));
                         cours = (rs.getString("cours"));
        		
				
			}
                       
                        System.out.println(oqp);
                        
                         System.out.println(Nombtnsalle);
                         System.out.println(cours);
                       
                         if (oqp.equalsIgnoreCase("oqp") ){
                             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                             alert.setTitle("Information sur la salle "+Nombtnsalle+"");
                             alert.setHeaderText("Cette salle n'est pas disponible!");
                             alert.setContentText("Cours: "+cours+"");
                             
                             alert.showAndWait();
                             
                         } else {
                                 
                             
                             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                             alert.setTitle("Information sur la salle "+Nombtnsalle+"");
                             alert.setHeaderText("Cette salle est disponible!");
                             alert.setContentText("Faite vite de vous inscrire");
                             
                             alert.showAndWait();
                             
                         }
                      
                        
                        
                        
                        
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
    
    private void affichage(){
    
        
        
        btnsalle1.setText(salle1);
        btnsalle2.setText(salle2);
        btnsalle3.setText(salle3);
        btnsalle4.setText(salle4);
        btnsalle5.setText(salle5);
        btnsalle6.setText(salle6);
        
        btn1color();
        btn2color();
        btn3color();
        btn4color();
        btn5color();
        btn6color();
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affichage();
    }    

    @FXML
    private void Retour(ActionEvent event) throws IOException  {
        
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        pane2.getChildren().setAll(pane1);
    }

   void btn1color(){
    
       
         String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
	try {
// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+btnsalle1.getText()+"' AND heure='"+Crenauxrecup+"' ";
                         rs = st.executeQuery(sql);
			while (rs.next()) {
		          oqp7 = (rs.getString("status"));
                 	}
                        if (oqp7.equalsIgnoreCase("oqp") ){
                         btnsalle1.setStyle("-fx-background-color: red;");
                         } else {
                         btnsalle1.setStyle("-fx-background-color: green;");
                        }
                
                        
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
    void btn2color(){
    
       
         String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
	try {
// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+btnsalle2.getText()+"' AND heure='"+Crenauxrecup+"' ";
                         rs = st.executeQuery(sql);
			while (rs.next()) {
		          oqp7 = (rs.getString("status"));
                 	}
                        if (oqp7.equalsIgnoreCase("oqp") ){
                         btnsalle2.setStyle("-fx-background-color: red;");
                         } else {
                         btnsalle2.setStyle("-fx-background-color: green;");
                        }
                
                        
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
    void btn3color(){
    
       
         String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
	try {
// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+btnsalle3.getText()+"' AND heure='"+Crenauxrecup+"' ";
                         rs = st.executeQuery(sql);
			while (rs.next()) {
		          oqp7 = (rs.getString("status"));
                 	}
                        if (oqp7.equalsIgnoreCase("oqp") ){
                         btnsalle3.setStyle("-fx-background-color: red;");
                         } else {
                         btnsalle3.setStyle("-fx-background-color: green;");
                        }
                
                        
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
    void btn4color(){
    
       
         String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
	try {
// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+btnsalle4.getText()+"' AND heure='"+Crenauxrecup+"' ";
                         rs = st.executeQuery(sql);
			while (rs.next()) {
		          oqp7 = (rs.getString("status"));
                 	}
                        if (oqp7.equalsIgnoreCase("oqp") ){
                         btnsalle4.setStyle("-fx-background-color: red;");
                         } else {
                         btnsalle4.setStyle("-fx-background-color: green;");
                        }
                
                        
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
    void btn5color(){
    
       
         String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
	try {
// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+btnsalle5.getText()+"' AND heure='"+Crenauxrecup+"' ";
                         rs = st.executeQuery(sql);
			while (rs.next()) {
		          oqp7 = (rs.getString("status"));
                 	}
                        if (oqp7.equalsIgnoreCase("oqp") ){
                         btnsalle5.setStyle("-fx-background-color: red;");
                         } else {
                         btnsalle5.setStyle("-fx-background-color: green;");
                        }
                
                        
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
    
    void btn6color(){
    
       
         String url = "jdbc:mysql://localhost/projettut";
		String login = "root";
		String passwd = "";
		java.sql.Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
	try {
// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM occupation WHERE  jours ='"+Joursrecup+"' AND salle ='"+btnsalle6.getText()+"' AND heure='"+Crenauxrecup+"' ";
                         rs = st.executeQuery(sql);
			while (rs.next()) {
		          oqp7 = (rs.getString("status"));
                 	}
                        if (oqp7.equalsIgnoreCase("oqp") ){
                         btnsalle6.setStyle("-fx-background-color: red;");
                         } else {
                         btnsalle6.setStyle("-fx-background-color: green;");
                        }
                
                        
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
