package testClasses;

public class AddressTestClass {

	public int publicInt = 444;
	public String publicSubString = "street";
	private String privateSubString;
	public String[][] arrayOfStrings = new String[4][4];
	public String[] singleArray = new String[5];
	
	public AddressTestClass(){
		//arrayOfStrings[0][0] = "ELEMENT IN ARRAY";
		//arrayOfStrings[3][3] = "Last Element";
		singleArray[0] = "Single";
	}
}
