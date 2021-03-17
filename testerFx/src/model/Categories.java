package model;

public class Categories {
private int idCat;
private String catName;


public Categories(int idCat, String catName) {
	super();
	this.idCat = idCat;
	this.catName = catName;
}





public int getIdCat() {
	return idCat;
}


public void setIdCat(int idCat) {
	this.idCat = idCat;
}


public String getCatName() {
	return catName;
}


public void setCatName(String catName) {
	this.catName = catName;
}


}
