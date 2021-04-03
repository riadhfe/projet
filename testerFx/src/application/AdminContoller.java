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
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Categories;


public class AdminContoller {
	
	@FXML
	private Button btnAjouter;
	@FXML
	private Button btnModifier;
	@FXML
	private Button btnSupp;
	//Scene window;
	//Stage win;
	public void Exit (ActionEvent ev) throws IOException {
		openModelWindow("View.fxml","Ingenious labs");	
	}
	
	
	
	public void AllCategories (ActionEvent ev) throws IOException {
	      
		openModelWindow("CategoryView.fxml","Categories");
	}	
			
			
			
	public void AllProducts (ActionEvent ev) throws IOException {
		
		openModelWindow("ProductView.fxml","Produits");
	  }
	
	public void AllCaissiers (ActionEvent ev) throws IOException {
		openModelWindow("Caissier.fxml","Caissiers");
				
	  }
	
	public void AllFournisseurs (ActionEvent ev) throws IOException {
		openModelWindow("FournisseurView.fxml","Fourniseurs");
				
	  }
	
	public void AllClients (ActionEvent ev) throws IOException {
		openModelWindow("ClientView.fxml","Clients");
				
	  }
	public void AllPromo (ActionEvent ev) throws IOException {
		openModelWindow("PromotionView.fxml","Promotion");
				
	  }
			
	public void openModelWindow(String resource, String title) {
	try {
		Parent root = FXMLLoader.load(getClass().getResource(resource));
		Scene fxmlFile = new Scene(root);
		Stage window = new Stage();
		window.setScene(fxmlFile);
		window.initModality(Modality.NONE);
		window.setTitle(title);
		window.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
	
	
	
	
	
}
	
	
	
	
	


