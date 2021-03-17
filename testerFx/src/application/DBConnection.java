package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Administrateur;
import model.Categories;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class DBConnection {

	 /*private static final String USERNAME = "root";
	    private static final String PASSWORD = "";
	    private static final String HOST = "127.0.0.1";
	    private static final int PORT = 3306;
	    private static final String DB_NAME = "pfe";*/
	    public static Connection con;
	    private PreparedStatement ps;
	    
	    
	    public static Connection getConnexion(){  
	    	try {   
	    		Class.forName("com.mysql.cj.jdbc.Driver");   
	    		//Chargement de driver JDBC   
	    		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "");  
	    		//System.out.println("Connection is established" );  
	    		   } 
	    	
	    	catch (Exception e) {   
	    		// TODO Auto-generated catch block  
	    		e.printStackTrace();  
	    		System.out.println("connection failed");  
	    		   }    
	    	
	    	return con;
	    	}
	    	
	 // récuperer la liste des catégories 
	 	public static ObservableList<Categories> getCategoryList() {
	 		
	 	ObservableList<Categories> listCategorie =FXCollections.observableArrayList();
	 	Connection conn= DBConnection.getConnexion();
	 	String req = "select * from category";
	 	PreparedStatement ps;
	 	ResultSet rs;
	 		try {
	 				ps=conn.prepareStatement(req);
	 		        rs=ps.executeQuery(req);
	 		       while (rs.next()) {
	 		           Categories c = new Categories(rs.getInt(1), rs.getString(2));
	 		           listCategorie.add(c);
	 		            }
	 		           } catch (Exception e) {
	 		            e.printStackTrace();
	 		        }
	 		        return listCategorie;
	 			
	 			
	 			}	
	    
	public static void  addCategory(Categories cat) {
	   try {
	    Connection conn= DBConnection.getConnexion();
	    PreparedStatement ps = conn.prepareStatement("insert into category values (?,?)");
	    ps.setInt(1, cat.getIdCat());
	    ps.setString(2, cat.getCatName());
	    ps.executeUpdate();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

}

