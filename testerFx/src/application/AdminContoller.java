package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.glass.ui.EventLoop.State;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Categories;


public class AdminContoller {
	
	@FXML
	private TextField txtdesc;
	@FXML
	private TableView<Categories> tabCategorie;
	@FXML
	private TableColumn<Categories, Integer> colId;
	@FXML
	private TableColumn<Categories, String> colName;
	@FXML
	private Button btnAjouter;
	@FXML
	private Button btnModifier;
	@FXML
	private Button btnSupp;
	
	public void Exit (ActionEvent ev) {
		Platform.exit();
		
	}
	
	
	
	public void AllCategories (ActionEvent ev) throws IOException {
	      //Aller à l'interface admin
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CategoryView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle(" Categories");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*lier les colonnes de la table avec les champs dans la base*/
			
			
	       /*colId.setCellValueFactory(new PropertyValueFactory<Categories,Integer>("idCat"));
	       colName.setCellValueFactory(new PropertyValueFactory<Categories,String>("nomCat"));
	       tabCategorie.setItems(DBConnection.getCategoryList());
	       //tabCategorie.getColumns().addAll(colId,colName);*/
	       
	}	
			
			
			
	public void AllProducts (ActionEvent ev) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ProductView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle(" Produits");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	  }
	
	public void AllCaissiers (ActionEvent ev) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Caissier.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle(" Caissiers");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	  }
	
	public void AllFournisseurs (ActionEvent ev) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("FournisseurView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle(" Fournisseurs");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	  }
	
	public void AllClients (ActionEvent ev) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Clients");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	  }
			
}
	
	
	
	
	


