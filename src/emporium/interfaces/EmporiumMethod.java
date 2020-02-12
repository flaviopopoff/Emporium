package emporium.interfaces;

import emporium.abstractclass.Product;

public interface EmporiumMethod {

	public double calculateEmporiumValue();
	public boolean containsCod(String cod);
	public void seeEmporium(boolean condition, String toSearch);
	public void addSellProduct(String toSearch, int quantity, boolean condition);	
	public void writeProducts(Product product);
	public String spaceWord(Object obj);
}
