package application;

import java.sql.Timestamp;
import java.util.Date;
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
import model.Client;

public class ClientController {
	@FXML
	private TableView<Client> clientTable;
	@FXML
	private TableColumn<Client, String> colid;
	@FXML
	private TableColumn<Client, String> colNom;
	@FXML
	private TableColumn<Client, String> colPrenom;
	@FXML
	private TableColumn<Client, Integer> colTel;
	@FXML
	private TableColumn<Client, Timestamp> colDate;
	
	// permet de la remplir depuis la base
	public void afficherClient(ActionEvent me) {
		ObservableList<Client> list = DBConnection.getClientList();	
		colid.setCellValueFactory(new PropertyValueFactory<Client,String>("iD"));
		colNom.setCellValueFactory(new PropertyValueFactory<Client,String>("firstName"));
		colPrenom.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName"));
		colTel.setCellValueFactory(new PropertyValueFactory<Client,Integer>("phoneNbr"));	
		colDate.setCellValueFactory(new PropertyValueFactory<Client,Timestamp>("dateInscrit"));
		clientTable.setItems(list);
	}
	
	public void Ajouter(ActionEvent e) {
		ajouterClient(clientTable);
	}

	private void ajouterClient(TableView<Client> table) {
		// TODO Auto-generated method stub
		Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter");
        //window.setMinWidth(250);
        VBox v = new VBox();
        v.getChildren().add(addTitle("Nouveau Client"));

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
        
        
     // add to gridpane
        g.getChildren().addAll(l1,firstName,l2,lastname,l3,phoneNbr);
   //// add buttons
        Button leftb = new Button("Annuler");
        leftb.setOnAction(e -> window.close());
        Button rightb = new Button("Confirmer");
        rightb.setOnAction(e -> {
        	if(phoneNbr.getText().matches("[0-9]{8,}")) {
        	Timestamp t = new Timestamp(newdate());
        	Client c = new Client(newID(), firstName.getText(), lastname.getText(), Integer.parseInt(phoneNbr.getText()), t);
            DBConnection.addClient(c);
            table.getItems().add(c);
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
        	System.out.println(clientTable.getSelectionModel().getSelectedIndex());
            DBConnection.deleteClient(clientTable.getSelectionModel().getSelectedItem());
            clientTable.getItems().remove(clientTable.getSelectionModel().getSelectedItem());
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
		modifierClient(clientTable,clientTable.getSelectionModel().getSelectedItem());
	}
	
	
	
	private void modifierClient(TableView<Client> table, Client selectedClient) {
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
        TextField id = new TextField(selectedClient.getID());
        id.setDisable(true);
        GridPane.setConstraints(id, 1, 0);
        // Firstname label
        Label l1 = new Label("Prenom");
        GridPane.setConstraints(l1, 0, 1);
        //Firstname input
        TextField firstName = new TextField(selectedClient.getFirstName());
        GridPane.setConstraints(firstName, 1, 1);
        //lastname label
        Label l2 = new Label("Nom");
        GridPane.setConstraints(l2, 0, 2);
        // lastname input
        TextField lastname = new TextField(selectedClient.getLastName());
        GridPane.setConstraints(lastname, 1,2);
        // phoneNbr label
        Label l3 = new Label("Numéro de tel");
        GridPane.setConstraints(l3, 0,3);
        // phoneNbr input
        TextField phoneNbr = new TextField(String.valueOf(selectedClient.getPhoneNbr()));
        GridPane.setConstraints(phoneNbr, 1, 3);
        
     // add to gridpane
        g.getChildren().addAll(l0,id,l1,firstName,l2,lastname,l3,phoneNbr);
   //// add buttons
        Button leftb = new Button("Annuler");
        leftb.setOnAction(e -> window.close());
        Button rightb = new Button("Confirmer");
        rightb.setOnAction(e -> {
          Client client = new Client(id.getText(), firstName.getText(), lastname.getText(), Integer.parseInt(phoneNbr.getText()), selectedClient.getDateInscrit());	
          DBConnection.deleteClient(selectedClient);
          DBConnection.addClient(client);
          clientTable.getItems().remove(selectedClient);
          clientTable.getItems().add(client);
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
