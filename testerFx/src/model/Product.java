package model;

public class Product {
	
	private String ProductID;
	private int CodeBarre;
    private String ProductName;
    private Double BuyingPrice;
    private Double SellingPrice;
    private String ProductCat;
    private int Qte;
    
    
	public Product(String productID, int codeBarre, String productName, Double buyingPrice, Double sellingPrice,
			String productCat, int qte) {
		super();
		ProductID = productID;
		CodeBarre = codeBarre;
		ProductName = productName;
		BuyingPrice = buyingPrice;
		SellingPrice = sellingPrice;
		ProductCat = productCat;
		Qte = qte;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getProductID() {
		return ProductID;
	}


	public void setProductID(String productID) {
		ProductID = productID;
	}


	public int getCodeBarre() {
		return CodeBarre;
	}


	public void setCodeBarre(int codeBarre) {
		CodeBarre = codeBarre;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public Double getBuyingPrice() {
		return BuyingPrice;
	}


	public void setBuyingPrice(Double buyingPrice) {
		BuyingPrice = buyingPrice;
	}


	public Double getSellingPrice() {
		return SellingPrice;
	}


	public void setSellingPrice(Double sellingPrice) {
		SellingPrice = sellingPrice;
	}


	public String getProductCat() {
		return ProductCat;
	}


	public void setProductCat(String productCat) {
		ProductCat = productCat;
	}


	public int getQte() {
		return Qte;
	}


	public void setQte(int qte) {
		Qte = qte;
	}
	
	

    
    
    
}
