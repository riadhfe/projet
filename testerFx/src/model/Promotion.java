package model;

public class Promotion {

	private String idPromo;
	private int pourcentage;
	
	
	public Promotion(String idPromo, int pourcentage) {
		super();
		this.idPromo = idPromo;
		this.pourcentage = pourcentage;
	}


	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
   

	public Promotion(int pourcentage) {
		super();
		this.pourcentage = pourcentage;
	}


	public String getIdPromo() {
		return idPromo;
	}


	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}


	public int getPourcentage() {
		return pourcentage;
	}


	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	
}
