package emporium.abstractclass;

import emporium.classes.Constants;

public abstract class Product {
	
	private String productName;
	private String productDepartment;
	private String productUnit;
	private String productCod;
	private String productCharacteristic;
	private int productQuantity;
	private double productPrice;
	
	public void setProductName(String productName) {

		if (productName.length() > 3 & productName.length() < 20) {
			this.productName = productName;
			Constants.isTrue = false;
			
		} else {
			
			System.out.println("Name to short/long.");
			System.out.println();
		}
	}
	
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductDepartment(String productDepartment) {
		
		if (productDepartment.equalsIgnoreCase("m") || productDepartment.equalsIgnoreCase("o") || 
			productDepartment.equalsIgnoreCase("p") || productDepartment.equalsIgnoreCase("s") || 
			productDepartment.equalsIgnoreCase("f")) {

			this.productDepartment = productDepartment;
			Constants.isTrue = false;

		} else {

			System.out.println("Department not correct.");
			System.out.println();
		}
	}

	public String getProductDepartment() {
		return productDepartment;
	}
	

	public void setProductUnit(String productUnit) {

		if (productUnit.equalsIgnoreCase("k") || productUnit.equalsIgnoreCase("m") ||
			productUnit.equalsIgnoreCase("l") || productUnit.equalsIgnoreCase("u")) {

			this.productUnit = productUnit;
			Constants.isTrue = false;

		} else {

			System.out.println("Unit not correct.");
			System.out.println();
		}
	}
	
	public String getProductUnit() {
		return productUnit;
	}
	
	
	public void setProductCod(String productCod) {

		if (productCod.length() < 8 || productCod.length() > 8) {

			System.out.println("Cod not correct.");
			System.out.println();

		} else {
			
			this.productCod = productCod;
			Constants.isTrue = false;
		}
	}

	public String getProductCod() {
		return productCod;
	}
	
	
	public void setProductCharacteristic(String productCharacteristic) {
			this.productCharacteristic = productCharacteristic;
	}

	public String getProductCharacteristic() {
		return productCharacteristic;
	}
	

	public void setProductQuantity(int productQuantity) {

		if (productQuantity > 0 & productQuantity <= Constants.MAX_QUANTITY) {
			this.productQuantity = productQuantity;
			Constants.isTrue = false;

		} else {

			System.out.println("Quantity not correct.");
			System.out.println();
		}
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	
	public void setProductPrice(double productPrice) {
		
		if (productPrice > 0 & productPrice <= Constants.MAX_PRICE) {
			this.productPrice = productPrice;
			Constants.isTrue = false;
			
		} else {
			
			System.out.println("Price not correct.");
			System.out.println();
		}
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
}
