package model;


import java.sql.Timestamp;
//import java.time.LocalDate;;

public class Caissier extends Person {
	
	private String username;
	private String password;
    private double salary;
	private Timestamp dateEmbauche;
	
	
	public Caissier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Caissier(String iD, String firstName, String lastName, int phoneNbr, String username, String password,
			double salary,Timestamp dateEmbauche) {
		super(iD, firstName, lastName, phoneNbr);
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.dateEmbauche = dateEmbauche;
	}

    public Caissier(String firstName, String lastName, int phoneNbr, String username, String password,
			double salary,Timestamp dateEmbauche) {
    	super(firstName, lastName, phoneNbr);
    	this.username = username;
		this.password = password;
		this.salary = salary;
		this.dateEmbauche = dateEmbauche;
    }
	public Caissier(String username, String password) {
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


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Timestamp getDateEmbauche() {
		return dateEmbauche;
	}


	public void setDateEmbauche(Timestamp dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	
	
	
	
	
	
	
	
	

}
