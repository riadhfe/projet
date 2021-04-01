package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrateur;
import model.Caissier;

public class UsersC implements UsersI {

@Override
public  Administrateur getAdmin(Administrateur a) {
    	
	    Connection con = DBConnection.getConnexion();
	    Administrateur admin = new Administrateur();
			
			try {
				String sql = "select * from administrateur where username=? and password=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,a.getUsername());
				ps.setString(2,a.getPassword());
	            ResultSet rs = ps.executeQuery();
	           
	            	while(rs.next()) {
	            		admin.setUsername(rs.getString(1));
		            	admin.setPassword(rs.getString(2));
		            	//return admin;
		            
		            	//con.close();
	            }
	            
	            }
	           
	            
			catch (SQLException e)
			{
				e.printStackTrace();	
				System.out.println("user not found !!!!");
				//return null;
			    
			
			}
			 return admin;
}

	public UsersC() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Caissier getCaissier(String login, String pw) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnexion();
	    Caissier cai = new Caissier();
			try {
				String sql = "select username, password from caissier where username = '"+login+"' and password = '"+pw+"'";
				PreparedStatement ps = con.prepareStatement(sql);
				//ps.setString(1,login);
				//ps.setString(2,pw);
	            ResultSet rs = ps.executeQuery();
	           
	            	while(rs.next()) {
	            		cai.setUsername(rs.getString(1));
	            		cai.setPassword(rs.getString(2));
		            	}
	            	//return cai;
	            }
	           
	            
			catch (SQLException e)
			{
				e.printStackTrace();	
				System.out.println("user not found !");
				//return null;
			    
			}
		
			 return cai;
		
	}

}
