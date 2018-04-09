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
public class FXMLdocumentrezdechausséController implements Initializable {

    @FXML
    private AnchorPane pane2;
    
     String oqp7;
    
     static String Nombtnsalle;
    
   
   
    @FXML
    private Button btn2;
    
    
    String oqp;
   String cours ;
   
   
    String salle1 = Connection.salle01;

    @FXML
    public Button btnsalle1;       
            
            
      static  String Crenauxrecup = FXMLDocumentController.Crenaux ;
    String Departementrecup = FXMLDocumentController.Departement ;
    static String Joursrecup = FXMLDocumentController.Jours ;
    
    
    @FXML
    private void btn1aff(ActionEvent event) throws IOException {

        Nombtnsalle = btnsalle1.getText();
       
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
    
        
        
        btnsalle1.setText(Connection.salle01);
        btn1color();
    
    }  
            
 @FXML
    private void Retour(ActionEvent event) throws IOException {
    
    
     //   Departement = FXMLDocumentController.cb.getValue();
       // Jours = FXMLDocumentController.cb1.getValue();
       // Crenaux = FXMLDocumentController.cb2.getValue();
      
    AnchorPane pane1 = FXMLLoader.load(getClass().getResource("FXMLdocumentetage2.fxml"));
    pane2.getChildren().setAll(pane1);
   
    }
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affichage();
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
    
}


