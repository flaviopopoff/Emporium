package emporium.interfaces;

public interface EmporiumMethod {

	public double calculateEmporiumValue();
	public boolean containsCod(String cod);
	public void seeEmporium(boolean condition, String toSearch);
	public void addSellProduct(String toSearch, int quantity, boolean condition);
	public void writeProduct(String name, String department, String unit, String cod, String characteristic, 
			int quantity, double price);
}
