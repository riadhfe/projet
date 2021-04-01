package model;



public class Administrateur extends Person {
	private String username;
	private String password;
		
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Administrateur(String iD, String firstName, String lastName, int phoneNbr, String username, String password) {
		super(iD, firstName, lastName, phoneNbr);
		this.username = username;
		this.password = password;
	}
     
	
	
	public Administrateur(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	}
	
	
	


