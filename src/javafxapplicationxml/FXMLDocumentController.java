/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationxml;

import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author etudiant1
 */
public class FXMLDocumentController implements Initializable {
    Stage stage = new Stage();
    
    
    
    
  ObservableList list = FXCollections.observableArrayList();
  ObservableList list1 = FXCollections.observableArrayList();
  
  
  public static String Departement ;
   public static String Jours;
   public static String Crenaux;
   
  
   //mouseWheelMoved(MouseWheelEvent)
  
   
  @FXML
  Button btn1 = new Button();
 
    @FXML
    public  ChoiceBox<String> cb ;
    
    @FXML
    public  ChoiceBox<String> cb1;
    
    @FXML
    public  ChoiceBox<String> cb2;
    
    @FXML
    private  AnchorPane pane1;
    
    @FXML
    DatePicker datePicker = new DatePicker();
    
    void departementiut()throws IOException {
        Connection.lireEnBase();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
        pane1.getChildren().setAll(pane2);
        
    }
   
    void departement()throws IOException {
        Connection.lireEnBaseAutredepartement();
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("AutredepartementFXML.fxml"));
        pane1.getChildren().setAll(pane2);
    }
    
   
    @FXML
    private void loadSecond(ActionEvent event ) throws IOException{

     
        
        Departement = cb.getValue();
        Jours = cb1.getValue();
        Crenaux = cb2.getValue();
        
        Connection.departementChoisie = Departement;
        Connection.joursChoisie = Jours;
        Connection.HeureChoisie = Crenaux;
        
        
        
        if( Departement == "iut"){
       
            
            departementiut();
         } else  {
         departement();
         
         }
        
        
         
         
        
        
        
         
    }
    
   
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    private void loaddata (){
   
   String a = "faculté_de_droit";
   String b = "dsi";
   String c = "faculté_de_lettres";
   String d = "iut";
   
   
   list.addAll(a,b,c,d);
    cb.getItems().addAll(list);
    cb.getSelectionModel().selectFirst();
    cb1.getItems().addAll("lundi","mardi","mercredi","jeudi","vendredi","samedi");
    cb1.getSelectionModel().selectFirst();
    cb2.getItems().addAll("7H-8H","8H-9H","9H-10H","10H-11H","11H-12H","13H-14H","15H-16H","16H-17H");
    cb2.getSelectionModel().selectFirst();
    
    }
    
     
    
     
     
            
            
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loaddata ();
        
        
        
        
        
        
    }    
    
}
