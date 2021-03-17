package model;

import java.sql.Date;;

public class Caissier extends Person {
	
	private String username;
	private String password;
    private double salary;
	private Date date_Embauche;
	
	
	public Caissier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Caissier(int iD, String firstName, String lastName, int phoneNbr, String username, String password,
			double salary, Date date_Embauche) {
		super(iD, firstName, lastName, phoneNbr);
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.date_Embauche = date_Embauche;
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


	public Date getDate_Embauche() {
		return date_Embauche;
	}


	public void setDate_Embauche(Date date_Embauche) {
		this.date_Embauche = date_Embauche;
	}
	
	
	
	
	
	
	
	
	
	

}
