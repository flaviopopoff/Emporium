package emporium.interfaces;

import emporium.abstractclass.Product;

public interface EmporiumMethod {

	double calculateEmporiumValue();
	boolean containsCod(String cod);
	void seeEmporium(boolean condition, String toSearch);
	void addSellProduct(String toSearch, int quantity, boolean condition);
	void writeProducts(Product product);
	<T> String spaceWord(T obj);
}
