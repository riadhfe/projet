package application;

import java.sql.Timestamp;
import java.util.Date;
//import java.sql.Date;
import java.util.UUID;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
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
import model.Caissier;


public class CaissierController {
	
	@FXML
	private TableView<Caissier> caissierTable;
	@FXML
	private TableColumn<Caissier, String> colId;
	@FXML
	private TableColumn<Caissier, String> colNom;
	@FXML
	private TableColumn<Caissier, String> colPrenom;
	@FXML
	private TableColumn<Caissier, String> colLogin;
	@FXML
	private TableColumn<Caissier, String> colPw;
	@FXML
	private TableColumn<Caissier, Integer> colTel;
	@FXML
	private TableColumn<Caissier, Timestamp> colDate;
	@FXML
	private TableColumn<Caissier, Double> colSalaire;
	
	
	
	
	
	
	
	// permet de la remplir depuis la base
		public void afficherCaissier(ActionEvent me) {
		ObservableList<Caissier> list = DBConnection.getCaissierList();	
		colId.setCellValueFactory(new PropertyValueFactory<Caissier,String>("iD"));
		colNom.setCellValueFactory(new PropertyValueFactory<Caissier,String>("firstName"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<Caissier,String>("lastName"));
		colTel.setCellValueFactory(new PropertyValueFactory<Caissier,Integer>("phoneNbr"));
		colLogin.setCellValueFactory(new PropertyValueFactory<Caissier,String>("username"));
		colPw.setCellValueFactory(new PropertyValueFactory<Caissier,String>("password"));
		colSalaire.setCellValueFactory(new PropertyValueFactory<Caissier,Double>("salary"));
		colDate.setCellValueFactory(new PropertyValueFactory<Caissier,Timestamp>("dateEmbauche"));
		caissierTable.setItems(list);
		}
	
		public void Ajouter(ActionEvent e) {
			ajouterCa(caissierTable);
		}

		private void ajouterCa(TableView<Caissier> table) {
			// TODO Auto-generated method stub
			Stage window = new Stage();

	        window.initModality(Modality.APPLICATION_MODAL);
	        window.setTitle("Ajouter");
	        //window.setMinWidth(250);
	        VBox v = new VBox();
	        v.getChildren().add(addTitle("Nouveau Caissier"));

	        GridPane g = new GridPane();
	        g.setPadding(new Insets(10, 10, 10, 10));
	        g.setHgap(10);
	        g.setVgap(8);

	        // Firstname label
	        Label l1 = new Label("Prenom");
	        GridPane.setConstraints(l1, 0, 0);
	        //Firstname input
	        TextField firstName = new TextField();
	        GridPane.setConstraints(firstName, 1, 0);
	        //lastname label
	        Label l2 = new Label("Nom");
	        GridPane.setConstraints(l2, 0, 1);
	        // lastname input
	        TextField lastname = new TextField();
	        GridPane.setConstraints(lastname, 1, 1);
	        // phoneNbr label
	        Label l3 = new Label("Numéro de tel");
	        GridPane.setConstraints(l3, 0, 2);
	        // phoneNbr input
	        TextField phoneNbr = new TextField();
	        GridPane.setConstraints(phoneNbr, 1, 2);
	        // login label
	        Label l4 = new Label("Login");
	        GridPane.setConstraints(l4, 0, 3);
	        //login input
	        TextField login = new TextField();
	        GridPane.setConstraints(login, 1, 3);
	        // Pw label
	        Label l5 = new Label("Mot de passe");
	        GridPane.setConstraints(l5, 0, 4);
	        // Pw input
	        TextField pw = new TextField();
	        GridPane.setConstraints(pw, 1, 4);
	       // salary label
	        Label l6 = new Label("Salaire");
	        GridPane.setConstraints(l6, 0, 5);
	        // salary input
	        TextField salary = new TextField();
	        GridPane.setConstraints(salary, 1, 5);
	        
	        // add to gridpane
	        g.getChildren().addAll(l1,firstName,l2,lastname,l3,phoneNbr,l4,login,l5,pw,l6,salary);

	        //// add buttons
	        Button leftb = new Button("Annuler");
	        leftb.setOnAction(e -> window.close());
	        Button rightb = new Button("Confirmer");
	        rightb.setOnAction(e -> {
	        	if(phoneNbr.getText().matches("[0-9]{8,}")) {
	        		
	        	 Timestamp t = new Timestamp(newdate());
               Caissier ca = new Caissier(newID(), firstName.getText(), lastname.getText(), Integer.parseInt(phoneNbr.getText()), login.getText(), pw.getText(), Double.parseDouble(salary.getText()),t );
	           
	            DBConnection.addCassier(ca);
	            table.getItems().add(ca);
	            window.close();
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Message");
	            alert.setHeaderText("Succès");
	            alert.setContentText("Ajout  fait avec succès !");
	            alert.show();}
	        	else {
	        	Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Message");
	            alert.setHeaderText("Numéro de telephone");
	            alert.setContentText("Veuillez saisir un nombre de 8 chiffres !");
	            alert.show();
	        		
	        	}

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
		
		public void delete(ActionEvent e) {
			delete1();
		}
		
		public void delete1() {
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
	        Label l0 = new Label("Etes-vous sure de vouloir supprimer ce caissier ?");
	        GridPane.setConstraints(l0, 0, 0);
	        g.getChildren().addAll(l0);
	        
	        Button leftb = new Button("Annuler");
	        leftb.setOnAction(e -> window.close());
	        Button rightb = new Button("Confirmer");
	        rightb.setOnAction(e -> {
	        System.out.println(caissierTable.getSelectionModel().getSelectedIndex());
	        DBConnection.deleteCaissier(caissierTable.getSelectionModel().getSelectedItem());
	        caissierTable.getItems().remove(caissierTable.getSelectionModel().getSelectedItem());
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
		
		public void modifier(ActionEvent e) {
			modifierCaissier(caissierTable,caissierTable.getSelectionModel().getSelectedItem());
		}
		
		
	
		private void modifierCaissier(TableView<Caissier> table, Caissier selectedItem) {
			// TODO Auto-generated method stub
			Stage window = new Stage();

	        window.initModality(Modality.APPLICATION_MODAL);
	        window.setTitle("Modifier");
	        //window.setMinWidth(250);
	        VBox v = new VBox();
	        v.getChildren().add(addTitle("Modifier Caissier"));

	        GridPane g = new GridPane();
	        g.setPadding(new Insets(10, 10, 10, 10));
	        g.setHgap(10);
	        g.setVgap(8);
	        
	        // id label
	        Label l0 = new Label("Id");
	        GridPane.setConstraints(l0, 0, 0);
	        // id input
	        TextField id = new TextField(selectedItem.getID());
	        id.setDisable(true);
	        GridPane.setConstraints(id, 1, 0);
	        // Firstname label
	        Label l1 = new Label("Prenom");
	        GridPane.setConstraints(l1, 0, 1);
	        //Firstname input
	        TextField firstName = new TextField(selectedItem.getFirstName());
	        GridPane.setConstraints(firstName, 1, 1);
	        //lastname label
	        Label l2 = new Label("Nom");
	        GridPane.setConstraints(l2, 0, 2);
	        // lastname input
	        TextField lastname = new TextField(selectedItem.getLastName());
	        GridPane.setConstraints(lastname, 1,2);
	        // phoneNbr label
	        Label l3 = new Label("Numéro de tel");
	        GridPane.setConstraints(l3, 0,3);
	        // phoneNbr input
	        TextField phoneNbr = new TextField(String.valueOf(selectedItem.getPhoneNbr()));
	        GridPane.setConstraints(phoneNbr, 1, 3);
	        // login label
	        Label l4 = new Label("Login");
	        GridPane.setConstraints(l4, 0, 4);
	        //login input
	        TextField login = new TextField(selectedItem.getUsername());
	        GridPane.setConstraints(login, 1, 4);
	        // Pw label
	        Label l5 = new Label("Mot de passe");
	        GridPane.setConstraints(l5, 0, 5);
	        // Pw input
	        TextField pw = new TextField(selectedItem.getPassword());
	        GridPane.setConstraints(pw, 1, 5);
	       // salary label
	        Label l6 = new Label("Salaire");
	        GridPane.setConstraints(l6, 0, 6);
	        // salary input
	        TextField salary = new TextField(String.valueOf(selectedItem.getSalary()));
	        GridPane.setConstraints(salary, 1, 6);
	        // add to gridpane
	        g.getChildren().addAll(l0,id,l1,firstName,l2,lastname,l3,phoneNbr,l4,login,l5,pw,l6,salary);

	        //// add buttons
	        Button leftb = new Button("Annuler");
	        leftb.setOnAction(e -> window.close());
	        Button rightb = new Button("Confirmer");
	        rightb.setOnAction(e -> {
	        Caissier caissier = new Caissier(id.getText(), firstName.getText(), lastname.getText(), Integer.parseInt(phoneNbr.getText()), login.getText(), pw.getText(), Double.parseDouble(salary.getText()), selectedItem.getDateEmbauche());
	        DBConnection.deleteCaissier(selectedItem);
	        DBConnection.addCassier(caissier);
	        caissierTable.getItems().remove(selectedItem);
	        caissierTable.getItems().add(caissier);
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

		public Text addTitle(String title) {
	        Text t = new Text(title);
	        t.setFont(Font.font("Arial", 18));
	        return t;
	    }

	    private String newID() {
	        String uuid = UUID.randomUUID().toString();
	        return uuid.substring(0, uuid.indexOf('-'));
	    }
	    public Long newdate() {
	        Date date = new Date();
	        return date.getTime();
	    }

}
