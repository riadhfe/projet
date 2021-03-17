package model;

import java.sql.Date;

public class Client extends Person {
	private Date DateInscrit;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int iD, String firstName, String lastName, int phoneNbr, Date dateInscrit) {
		super(iD, firstName, lastName, phoneNbr);
		DateInscrit = dateInscrit;
	}

	public Date getDateInscrit() {
		return DateInscrit;
	}

	public void setDateInscrit(Date dateInscrit) {
		DateInscrit = dateInscrit;
	}

	
	
	
	
	

}
