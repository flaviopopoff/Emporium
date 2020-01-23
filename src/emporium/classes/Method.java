package emporium.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import emporium.interfaces.EmporiumMethod;
import emporium.interfaces.SpaceWord;

public class Method implements EmporiumMethod {
	
	private BufferedReader reader = null;
	private FileWriter writer = null;

	
	@Override
	public double calculateEmporiumValue() {
				
		String line;
		int quantity = 0;
		double price = 0, sum = 0;
		
		
		try {
			
			reader = new BufferedReader(new FileReader(Constants.FILE));
			
		} catch (FileNotFoundException pd) {
			pd.printStackTrace();
		}

		
		try {
			
			while ((line = reader.readLine()) != null) {
				
				String[] splits = line.split(";");
				
				quantity = Integer.parseInt(splits[5]);
				price = Double.parseDouble(splits[6]);
				
				sum += (quantity * price);
			}
			
		} catch (IOException pd) {
			pd.printStackTrace();

		} finally {

			try {
				
				reader.close();

			} catch (IOException pd) {
				pd.printStackTrace();
			}
		}
		
		return sum;
	}
	
	
	@Override
	public boolean containsCod(String cod) {

		boolean contains = false;
		String line;
		
		try {
			
			reader = new BufferedReader(new FileReader(Constants.FILE));
			
		} catch (FileNotFoundException pd) {
			pd.printStackTrace();
		}
		
		try {
			
			while((line = reader.readLine()) != null) {
				
				String[] splits = line.split(";");
				
				String codFound = splits[3];
				
				if(cod.equals(codFound)) {
					contains = true;
				}	
			}
			
		} catch (IOException pd) {
			pd.printStackTrace();
			
		} finally {

			try {

				reader.close();

			} catch (IOException pd) {
				pd.printStackTrace();
			}
		}
		
		return contains;
	}
	
	
	@Override
	public void seeEmporium(boolean condition, String search) {

		String line;
		boolean isContains = true;
		
		SpaceWord spaceWord = new SpaceWord() {
		
			@Override
			public String spaceWord(String word) {
				
				String emptySpace = "";
				
				if (word.length() == 1) {

					for (int x = 0; x <= Constants.LENGTH_STRING_DU - word.length(); x++) {
						emptySpace += " ";
					}
					
				} else {
					
					for (int y = 0; y <= Constants.LENGTH_STRING - word.length(); y++) {
						emptySpace += " ";
					}
				}
				
				return emptySpace;
			}
			
			
			@Override
			public String spaceWord(int quantity) {
				
				String emptySpace = "";
				String quantityToString = Integer.toString(quantity);
				
				for(int x = 0; x <= Constants.LENGTH_INT - quantityToString.length(); x++) {
					emptySpace = emptySpace + " ";
				}
				
				return emptySpace;
			}
			
			
			@Override
			public String spaceWord(double price) {

				String emptySpace = "";
				String priceToString = Double.toString(price);
				
				for(int x = 0; x <= Constants.LENGTH_FLOAT - priceToString.length(); x++) {
					emptySpace = emptySpace + " ";
				}
				
				return emptySpace;
			}
		};
		

		try {

			reader = new BufferedReader(new FileReader(Constants.FILE));

		} catch (FileNotFoundException ee) {
			ee.printStackTrace();
		}

		
		try {
			
			System.out.println("Name             Dep.      Unit      Cod              Quantity     Price        Characteristic");
			System.out.println("----------------------------------------------------------------------------------------------");
			
			while ((line = reader.readLine()) != null) {
				
				if (condition || (line.indexOf(search) != -1)) {
					
					String[] splits = line.split(";");

					String name = splits[0];
					String department = splits[1];
					String unit = splits[2];
					String cod = splits[3];
					String characteristic = splits[4];
					int quantity = Integer.parseInt(splits[5]);
					double price = Double.parseDouble(splits[6]);

					System.out.println(name + spaceWord.spaceWord(name) + department + spaceWord.spaceWord(department)
							+ unit + spaceWord.spaceWord(unit) + cod + spaceWord.spaceWord(cod) + quantity
							+ spaceWord.spaceWord(quantity) + price + spaceWord.spaceWord(price) + characteristic
							+ spaceWord.spaceWord(characteristic));
					System.out.println(
							"----------------------------------------------------------------------------------------------");
					isContains = false;
				}
			}
			
			if (isContains) {
				System.out.println("Product not present.");
			}

		} catch (NumberFormatException | IOException pd) {
			pd.printStackTrace();
			
		} finally {

			try {

				reader.close();

			} catch (IOException pd) {
				pd.printStackTrace();
			}
		}

	}
	

	@Override
	public void writeProduct(String name, String department, String unit, String cod,
											String characteristic, int quantity, double price) {

		try {

			writer = new FileWriter(Constants.FILE, true);
			writer.write(name + ";" + department + ";" + unit + ";" + cod + ";" + characteristic
					+ ";" + quantity + ";" + price + "\r\n");
			
			System.out.println("Product insert correctly.");
			System.out.println();

		} catch (IOException pd) {
			pd.printStackTrace();

		} finally {

			try {

				writer.close();

			} catch (IOException pd) {
				pd.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public void addSellProduct(String toSearch, int quantityAddSell, boolean condition) {
		
		String name = null, deparment = null, unit = null, cod = null, characteristic = null, line;
		int quantity = 0;
		double price = 0;
		
		boolean isContains = true;
		
		
		try {
			
			reader = new BufferedReader(new FileReader(Constants.FILE));
			writer = new FileWriter(Constants.NEW_FILE, true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		try {

			while ((line = reader.readLine()) != null) {
				
				String[] splits = line.split(";");
				
				name = splits[0];
				deparment = splits[1];
				unit = splits[2];
				cod = splits[3];
				characteristic = splits[4];
				quantity = Integer.parseInt(splits[5]);
				price = Double.parseDouble(splits[6]);
				
				if (cod.equals(toSearch)) {
					
					isContains = false;
					
					if (condition) {
						
						if (quantityAddSell > quantity) {
							
							writer.write(name + ";" + deparment + ";" + unit + ";" + cod + ";" + characteristic 
									+ ";" + quantity + ";" + price + "\r\n");
							System.out.println("Quantity not available.");
							
						} else if (quantityAddSell == quantity) {
							System.out.println("Product out of stock.");
							
						} else {
							
							int newQuantity = quantity - quantityAddSell;
							writer.write(name + ";" + deparment + ";" + unit + ";" + cod + ";" + characteristic 
									+ ";" + newQuantity + ";" + price + "\r\n");
							System.out.println("Product sold successfully.");
						}
						
					} else {
						
						if (quantityAddSell < 0 || quantityAddSell > Constants.MAX_QUANTITY) {
							
							System.out.println("Quantity not possible to add.");
							writer.write(name + ";" + deparment + ";" + unit + ";" + cod + ";" + characteristic 
									+ ";" + quantity + ";" + price + "\r\n");
							
						} else {
							
							int newQuantity = quantityAddSell + quantity;
							writer.write(name + ";" + deparment + ";" + unit + ";" + cod + ";" + characteristic 
									+ ";" + newQuantity + ";" + price + "\r\n");
							System.out.println("Quantity add successfully.");
						}
					}
					
				} else {
					writer.write(name + ";" + deparment + ";" + unit + ";" + cod + ";" + characteristic + ";"
							+ quantity + ";" + price + "\r\n");
				}
			}
			
			if (isContains) {
				System.out.println("Product not present.");
			}

		} catch (IOException pd) {
			pd.printStackTrace();

		} finally {

			try {
				
				reader.close();
				writer.close();
				
				Constants.FILE.delete();
				Constants.NEW_FILE.renameTo(Constants.FILE);

			} catch (IOException pd) {
				pd.printStackTrace();
			}
		}
		
	}
	
}
