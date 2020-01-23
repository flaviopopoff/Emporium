package emporium.classes;

import java.io.File;

public final class Constants {
	
	public final static int LENGTH_STRING = 16;
	public final static int LENGTH_STRING_DU = 9;
	public final static int LENGTH_INT = 12;
	public final static int LENGTH_FLOAT = 12;
	
	public final static int MAX_QUANTITY = 1500;
	public final static int MAX_PRICE = 2500;
	
	public static boolean isTrue = true;
	
	public final static String FILE_NAME = "Emporium.txt";
	public final static String NEW_FILE_NAME = "NewEmporium.txt";
	
	public final static File FILE = new File(FILE_NAME);
	public final static File NEW_FILE = new File(NEW_FILE_NAME);
	
}
