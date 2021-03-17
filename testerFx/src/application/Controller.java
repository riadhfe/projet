package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Administrateur;
import model.Caissier;
import application.DBConnection;

public class Controller {
	
	@FXML 
	private Label lab;
	@FXML 
	private TextField txtLogin;
	@FXML 
	private PasswordField txtPw;
	@FXML 
	private RadioButton btnAdmin;
	@FXML 
	private RadioButton btnCaissier;
	@FXML 
	private Label label;
	
	
	
	
	//pour tester la cnx avec la base
	public void DBStatus(ActionEvent e)throws IOException, SQLException {
		if (! DBConnection.getConnexion().isClosed()) {
			label.setText("Connected");
			
		}
		else {
			label.setText(" Not Connected");
		}
	}
	
	//clic sur le bouton quitter
	public void Exit (ActionEvent ev) {
		Platform.exit();
		
	}
	//clic sur le bouton se connecter
	public void Enter (ActionEvent e)throws IOException, SQLException {
		
	
     Administrateur adm = new Administrateur(txtLogin.getText(), txtPw.getText());
     Caissier c = new Caissier(txtLogin.getText(), txtPw.getText());
     
     UsersC user= new UsersC();
     
     Administrateur admn = user.getAdmin(adm); 
     Caissier cai = user.getCaissier(c);
     
     if(btnAdmin.isSelected()) {
    	 if(admn!=null) {
    		 if((! txtLogin.getText().isEmpty()) && (! txtPw.getText().isEmpty())) {
    			 DBConnection.getConnexion();
         	    //aller à l'interface admin 
     			Stage primaryStage = new Stage();
     			Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
     			Scene scene = new Scene(root);
     			primaryStage.setTitle("Admin View");
     			primaryStage.setScene(scene);
     			primaryStage.show();
    			 
    		 }
    		 else {
    			 Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Alerte");
                 alert.setHeaderText("Erreur de connection");
                 alert.setContentText("Veuillez remplir les champs !");
                 alert.show();
    			 
    		 }
    		 
    	 }
    	 else {
    		 Alert alert = new Alert(AlertType.WARNING);
    	        alert.setTitle("Alerte");
    	        alert.setHeaderText("Erreur de connection");
    	        alert.setContentText("user n'existe pas");
    	        alert.show();
    			System.out.println("user n'existe pas !");
    		 
    	 }
    	 
     }
     else if (btnCaissier.isSelected()) {
    	 if(cai!=null) {
    		 if((! txtLogin.getText().isEmpty()) && (! txtPw.getText().isEmpty())) {
    			 DBConnection.getConnexion();
         	    //aller à l'interface caissier 
     			Stage primaryStage = new Stage();
     			Parent root = FXMLLoader.load(getClass().getResource("CaissierView.fxml"));
     			Scene scene = new Scene(root);
     			primaryStage.setTitle("Caissier View");
     			primaryStage.setScene(scene);
     			primaryStage.show();
    			 
    		 }
    		 else {
    			 Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Alerte");
                 alert.setHeaderText("Erreur de connection");
                 alert.setContentText("Veuillez remplir les champs !");
                 alert.show();
    			 
    		 }
    		 
    	 }
    	 else {
    		 Alert alert = new Alert(AlertType.WARNING);
    	        alert.setTitle("Alerte");
    	        alert.setHeaderText("Erreur de connection");
    	        alert.setContentText("user n'existe pas");
    	        alert.show();
    			System.out.println("user n'existe pas");
    		 
    	 }
    	 
     }
     else {
    	 Alert alert = new Alert(AlertType.WARNING);
         alert.setTitle("Alerte");
         alert.setHeaderText("Erreur de connection");
         alert.setContentText("Veuillez cocher un bouton !");
         alert.show();
     }
    	 

}
	
	
}
	
	


