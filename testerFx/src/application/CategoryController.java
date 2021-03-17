package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Categories;



public class CategoryController {
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNom;
	
	//private int id = Integer.parseInt(txtId.getText());
	
	Categories cat = new Categories(Integer.parseInt(txtId.getText()), txtNom.getText());
	/*Categories c = new Categories(id, txtNom.getText());*/
	
	public void AjouterCat (ActionEvent ev) {
		if((! txtId.getText().isEmpty()) && (! txtNom.getText().isEmpty()) ) {
			DBConnection.addCategory(cat);
			//rendre les champs vides
			txtId.setText("");
			txtNom.setText("");
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Erreur de connection");
            alert.setContentText("Veuillez remplir les champs !");
            alert.show();
		}
		
		
	}
	
	
	
	
	
	

}
