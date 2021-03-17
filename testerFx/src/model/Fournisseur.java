package model;

public class Fournisseur extends Person {
	private String produit;
	private String adresse;

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(int iD, String firstName, String lastName, int phoneNbr, String produit, String adresse) {
		super(iD, firstName, lastName, phoneNbr);
		this.produit = produit;
		this.adresse = adresse;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

	
	
	

}
