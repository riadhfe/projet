package model;

public class Person {
	private String ID;
    private String FirstName;
    private String LastName;
    private int PhoneNbr;
    
    
	public Person(String iD, String firstName, String lastName, int phoneNbr) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		PhoneNbr = phoneNbr;
	}

    
	public Person(String firstName, String lastName, int phoneNbr) {
		super();
		FirstName = firstName;
		LastName = lastName;
		PhoneNbr = phoneNbr;
	}


	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public int getPhoneNbr() {
		return PhoneNbr;
	}


	public void setPhoneNbr(int phoneNbr) {
		PhoneNbr = phoneNbr;
	}
	
	
    

}
