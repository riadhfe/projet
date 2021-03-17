package model;

public class Person {
	private int ID;
    private String FirstName;
    private String LastName;
    private int PhoneNbr;
    
    
	public Person(int iD, String firstName, String lastName, int phoneNbr) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		PhoneNbr = phoneNbr;
	}


	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
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
