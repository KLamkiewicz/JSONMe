package testClasses;

import java.util.ArrayList;
import java.util.List;

import pl.krzysiek.JSONMe.main.Types;

public class StreetTestClass {

	private double imPrivate = 40d;
	public float floating = 50f;
	public int[][][] filledArray = new int[4][4][4];
	public int[] emptyArray = new int[4];
	public String[] t = new String[3];
	//public List<String> rList = new ArrayList<String>();
	public AddressTestClass[] addresses = new AddressTestClass[4];
	public AddressTestClass rrrrr;
	public char charTest = 'x';
	public String stringTest = "xzzx";
	public Types enum1 = Types.String;
	public Types zz = Types.primitiveDouble;
	
	public StreetTestClass(){
		
		filledArray[0][0][0] = 5;
		filledArray[1][0][0] = 10;
		filledArray[0][1][0] = 40;
		t[0] = "zxzx";
		
		addresses[0] = new AddressTestClass();
		addresses[1] = new AddressTestClass();
		
	}
	
}
