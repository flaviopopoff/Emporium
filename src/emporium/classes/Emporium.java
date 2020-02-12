package emporium.classes;

import java.util.Scanner;

import emporium.abstractclass.Product;

public class Emporium extends Product {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean end = true;

		Emporium product = new Emporium();
		Method method = new Method();
		
		System.out.println("  ______                            _                      \n" + 
						   " |  ____|                          (_)                     \n" + 
						   " | |__   _ __ ___  _ __   ___  _ __ _ _   _ _ __ ___       \n" + 
						   " |  __| | '_ ` _ \\| '_ \\ / _ \\| '__| | | | | '_ ` _ \\  \n" + 
						   " | |____| | | | | | |_) | (_) | |  | | |_| | | | | | |     \n" + 
						   " |______|_| |_| |_| .__/ \\___/|_|  |_|\\__,_|_| |_| |_|   \n" + 
						   "                  | |                                      \n" + 
						   "                  |_|                                        ");
		
		do {

			System.out.println("------------------------------------");
			System.out.println("|| [0] Ends program.              ||");
			System.out.println("|| [1] Add product.               ||");
			System.out.println("|| [2] Calculate emporium value.  ||");
			System.out.println("|| [3] Emporium list.             ||");
			System.out.println("|| [4] Search product.            ||");
			System.out.println("|| [5] Sell product.              ||");
			System.out.println("|| [6] Add quantity to product.   ||");
			System.out.println("------------------------------------");

			System.out.print("Option: ");
			String choice = input.nextLine();

			switch (choice) {

			case "0":

				System.out.println("Program end.");
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				end = false;
				break;

			case "1":

				Constants.isTrue = true;
				String name;

				do {

					System.out.print("Name: ");
					name = input.nextLine();
					product.setProductName(name);

				} while (Constants.isTrue);

				System.out.println("Name of product: " + product.getProductName().toUpperCase() + ".");
				System.out.println();

				
				System.out.println("[F] Feed.       [P] Plants.");
				System.out.println("[M] Metalware.  [S] Sport.");
				System.out.println("[O] Other.");
				Constants.isTrue = true;
				String department;

				do {

					System.out.print("Department: ");
					department = input.nextLine().toUpperCase();
					product.setProductDepartment(department);

				} while (Constants.isTrue);

				System.out.println("Department of product: " + product.getProductDepartment() + ".");
				System.out.println();

				
				System.out.println("[M] Meter.   [L] Liter.");
				System.out.println("[U] Unit.    [K] Kilogram.");
				
				Constants.isTrue = true;
				String unit;

				do {

					System.out.print("Unit: ");
					unit = input.nextLine().toUpperCase();
					product.setProductUnit(unit);

				} while (Constants.isTrue);

				System.out.println("Unit of product: " + product.getProductUnit() + ".");
				System.out.println();

				
				Constants.isTrue = true;
				String cod;

				do {

					System.out.print("Cod: ");
					cod = input.nextLine();
					product.setProductCod(cod);
					
					if (method.containsCod(cod)) {

						Constants.isTrue = true;
						System.out.println("The cod is present.");
						System.out.println();
					}

				} while (Constants.isTrue || (method.containsCod(cod)));

				System.out.println("Cod of product: " + product.getProductCod() + ".");
				System.out.println();

				
				System.out.print("Characteristic: ");
				String characteristic = input.nextLine();

				if (characteristic.isEmpty()) {

					System.out.println("Nothing.");
					System.out.println();
					product.setProductCharacteristic(null);

				} else {

					product.setProductCharacteristic(characteristic);
					System.out.println("Characteristic of product: " + product.getProductCharacteristic() + ".");
					System.out.println();
				}

				Constants.isTrue = true;
				int quantity;

				do {

					try {

						System.out.print("Quantity: ");
						quantity = input.nextInt();
						product.setProductQuantity(quantity);

					} catch (Exception ignored) {
					}
					
					input.nextLine();

				} while (Constants.isTrue);

				System.out.println("Quantity of product: " + product.getProductQuantity() + ".");
				System.out.println();

				Constants.isTrue = true;
				double price;

				do {

					try {

						System.out.print("Price: € ");
						price = input.nextDouble();
						product.setProductPrice(price);

					} catch (Exception ignored) {
					}

					input.nextLine();

				} while (Constants.isTrue);

				System.out.println("Price of product: € " + product.getProductPrice());
				System.out.println();
				
				
				System.out.print("Write product in the file [y/n]? ");
				
				switch(input.nextLine()) {
				
				case "y":
				case "Y":
					
					method.writeProducts(product);
					break;
					
				default:
					System.out.println("Product not insert.");
					System.out.println();
					break;
				}
				
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;

			case "2":

				System.out.println("Value of emporium: € " + method.calculateEmporiumValue());
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;

			case "3":
				
				method.seeEmporium(true, null);
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;

			case "4":

				String search;
				
				do {

					System.out.print("Insert min 4 letters of the cod/name for the research of the product: ");
					search = input.nextLine();

				} while (search.length() < 4);

				method.seeEmporium(false, search);
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;

			case "5":

				String toSearch;
				
				do {

					System.out.print("Enter the cod of the product you want to sell: ");
					toSearch = input.nextLine();

				} while (toSearch.length() != 8);
				
				
				int quantitySell = 0;

				do {

					try {

						System.out.print("Quantity to sell: ");
						quantitySell = input.nextInt();

					} catch (Exception ignored) {
					}
					
					input.nextLine();

				} while (quantitySell < 1);

				method.addSellProduct(toSearch, quantitySell, true);
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;
				
			case "6":
				
				String code;
				
				do {

					System.out.print("Cod of the product to be supplied: ");
					code = input.nextLine();

				} while (code.length() != 8);
				
				
				int quantityAdd = 0;
				
				do {

					try {

						System.out.print("Quantity to supplied: ");
						quantityAdd = input.nextInt();

					} catch (Exception ignored) {
					}
					
					input.nextLine();

				} while (quantityAdd < 1);
				
				method.addSellProduct(code, quantityAdd, false);
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;
				
			default:
				
				System.out.println("Option not present.");
				System.out.println("___________________________________________________________________");
				System.out.println("___________________________________________________________________");
				System.out.println();
				break;
			}

		} while (end);

	}
}
