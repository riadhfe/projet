package application;

import java.util.UUID;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Product;
import model.Promotion;

public class PromotionController {
	@FXML
	private TableView<Promotion> tabPourc;
	@FXML
	private TableColumn<Promotion, String> colId;
	@FXML
	private TableColumn<Promotion, Integer> colPour;
	//consulter
	public void afficherPromo(ActionEvent me) {
		ObservableList<Promotion> list = DBConnection.getPromoList();	
		colId.setCellValueFactory(new PropertyValueFactory<Promotion,String>("idPromo"));
		colPour.setCellValueFactory(new PropertyValueFactory<Promotion,Integer>("pourcentage"));
		tabPourc.setItems(list);
		}
	
	
	
	
	// ajouter 
	public void Ajouter(ActionEvent e) {
		ajouterPromo(tabPourc);
	}

	private void ajouterPromo(TableView<Promotion> table) {
		// TODO Auto-generated method stub
		Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter");
        window.setMinWidth(250);
        
        VBox v = new VBox();
        v.getChildren().add(addTitle("Nouvelle Promotion"));

        GridPane g = new GridPane();
        g.setPadding(new Insets(10, 10, 10, 10));
        g.setHgap(10);
        g.setVgap(8);
       // % label
        Label l1 = new Label("Pourcentage");
        GridPane.setConstraints(l1, 0, 0);
        // % input
        TextField pour = new TextField();
        GridPane.setConstraints(pour, 1, 0);

        // add to gridpane
        g.getChildren().addAll(l1, pour);
   //// add buttons
        Button leftb = new Button("Annuler");
        leftb.setOnAction(e -> window.close());
        Button rightb = new Button("Confirmer");
        rightb.setOnAction(e -> {
        	
        		 Promotion pr = new Promotion(newID(),Integer.parseInt(pour.getText()));
        		 DBConnection.addPromo(pr);
                 table.getItems().add(pr);
                 window.close();
               //msg succès
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Message");
                 alert.setHeaderText("Succès !");
                 alert.setContentText("Ajout  fait avec succès !");
                 alert.show();
        });
        HBox b = new HBox(leftb, rightb);
        b.setPadding(new Insets(10, 10, 10, 10));
        b.setSpacing(20);
        b.setAlignment(Pos.CENTER_RIGHT);

        v.setAlignment(Pos.CENTER);
        v.setPadding(new Insets(20, 10, 10, 10));
        v.setSpacing(15);
        v.getChildren().addAll(g, b);

        Scene s = new Scene(v);
        window.setScene(s);
        window.show();
	}
	//modifier
	public void modifier(ActionEvent a) {
		modifierPour(tabPourc,tabPourc.getSelectionModel().getSelectedItem());
	}
	
	
	private void modifierPour(TableView<Promotion> table, Promotion selectedItem) {
		// TODO Auto-generated method stub
		Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Modifier");
        //window.setMinWidth(250);
        VBox v = new VBox();
        v.getChildren().add(addTitle("Modifier Client"));

        GridPane g = new GridPane();
        g.setPadding(new Insets(10, 10, 10, 10));
        g.setHgap(10);
        g.setVgap(8);
        // id label
        Label l0 = new Label("Id");
        GridPane.setConstraints(l0, 0, 0);
        // id input
        TextField id = new TextField(selectedItem.getIdPromo());
        id.setDisable(true);
        GridPane.setConstraints(id, 1, 0);
        // pourcentage  label
        Label l1 = new Label("Pourcentage");
        GridPane.setConstraints(l1, 0, 1);
        //pourcentage input
        TextField pour = new TextField(String.valueOf(selectedItem.getPourcentage()));
        GridPane.setConstraints(pour, 1, 1);
     // add to gridpane
        g.getChildren().addAll(l0,id,l1,pour);
       //// add buttons
        Button leftb = new Button("Annuler");
        leftb.setOnAction(e -> window.close());
        Button rightb = new Button("Confirmer");
        rightb.setOnAction(e -> {
        	Promotion p = new Promotion(id.getText(), Integer.parseInt(pour.getText()));
        	DBConnection.deletePromo(selectedItem);
            DBConnection.addPromo(p);
            tabPourc.getItems().remove(selectedItem);
            tabPourc.getItems().add(p);
  	        window.close();
  	        Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Message");
              alert.setHeaderText(" succès !");
              alert.setContentText("Modification faite avec succès !");
              alert.show();
        });
        HBox hb = new HBox(leftb, rightb);
        hb.setPadding(new Insets(10, 10, 10, 10));
        hb.setSpacing(20);
        hb.setAlignment(Pos.CENTER_RIGHT);

        v.setAlignment(Pos.CENTER);
        v.setPadding(new Insets(20, 10, 10, 10));
        v.setSpacing(15);
        v.getChildren().addAll(g, hb);

        Scene sc = new Scene(v);
        window.setScene(sc);
        window.show();
	}
    //supprimer 
	public void delete(ActionEvent e) {
		delete1();
	}


	private void delete1() {
		// TODO Auto-generated method stub
		Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Attention");
        //window.setMinWidth(250);
        VBox v = new VBox();
        v.getChildren().add(addTitle("Attention"));

        GridPane g = new GridPane();
        g.setPadding(new Insets(10, 10, 10, 10));
        g.setHgap(10);
        g.setVgap(8);
        //label
        Label l0 = new Label("Etes-vous sure de vouloir supprimer cette promotion?");
        GridPane.setConstraints(l0, 0, 0);
        g.getChildren().addAll(l0);
        
        Button leftb = new Button("Annuler");
        leftb.setOnAction(e -> window.close());
        Button rightb = new Button("Confirmer");
        rightb.setOnAction(e -> {
        	System.out.println(tabPourc.getSelectionModel().getSelectedIndex());
            DBConnection.deletePromo(tabPourc.getSelectionModel().getSelectedItem());
            tabPourc.getItems().remove(tabPourc.getSelectionModel().getSelectedItem());
        window.close();
        });
        HBox hb = new HBox(leftb, rightb);
        hb.setPadding(new Insets(10, 10, 10, 10));
        hb.setSpacing(20);
        hb.setAlignment(Pos.CENTER_RIGHT);

        v.setAlignment(Pos.CENTER);
        v.setPadding(new Insets(20, 10, 10, 10));
        v.setSpacing(15);
        v.getChildren().addAll(g, hb);

        Scene sc = new Scene(v);
        window.setScene(sc);
        window.show();
		
	}




	public Text addTitle(String title) {
        Text t = new Text(title);
        t.setFont(Font.font("Arial", 20));
        return t;
    }
	 private String newID() {
	        String uuid = UUID.randomUUID().toString();
	        return uuid.substring(0, uuid.indexOf('-'));
	    }
}
