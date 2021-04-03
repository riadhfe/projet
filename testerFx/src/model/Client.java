package model;


import java.sql.Timestamp;

public class Client extends Person {
	private Timestamp DateInscrit;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String iD, String firstName, String lastName, int phoneNbr, Timestamp dateInscrit) {
		super(iD, firstName, lastName, phoneNbr);
		DateInscrit = dateInscrit;
	}

	public Timestamp getDateInscrit() {
		return DateInscrit;
	}

	public void setDateInscrit(Timestamp dateInscrit) {
		DateInscrit = dateInscrit;
	}

	
	
	
	
	

}
