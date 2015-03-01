package testClasses;

import java.util.ArrayList;
import java.util.List;

public class StreetTestClass {

	private double imPrivate = 40d;
	public float imNot = 50f;
	public int[] filledArray = new int[4];
	public int[] emptyArray = new int[4];
	public List<String> rList = new ArrayList<String>();
	public AddressTestClass[] addresses = new AddressTestClass[4];
	
	public StreetTestClass(){
		rList.add("ZZZ");
		rList.add("GGGG");
		
		filledArray[0] = 5;
		filledArray[1] = 10;
		addresses[0] = new AddressTestClass();
		addresses[1] = new AddressTestClass();
		
	}
	
}
