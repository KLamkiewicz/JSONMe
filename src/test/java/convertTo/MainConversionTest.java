package convertTo;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import pl.krzysiek.JSONMe.exceptions.NoDataToConvertException;
import pl.krzysiek.JSONMe.exceptions.UnreasonableJSONException;
import pl.krzysiek.JSONMe.main.JSONMeObject;
import testClasses.EmptyClass;
import testClasses.PersonTestClass;
import testClasses.StreetTestClass;

public class MainConversionTest {

	@Test(expected=NoDataToConvertException.class)
	public void NoDataToConvertExceptionTest() throws Exception{
		System.out.println(JSONMeObject.getJSON(null));
	}
	
	@Test
	public void printTest() throws NoDataToConvertException, UnreasonableJSONException{
//		System.out.println(JSONMeObject.getJSON(new PersonTestClass()));
//		System.out.println(JSONMeObject.getJSON(new StreetTestClass()));
//		System.out.println(JSONMeObject.getJSON(new PersonTestClass()));
//		System.out.println(JSONMeObject.getJSON(new EmptyClass()));
//		
		System.out.println(JSONMeObject.getJSON(new StreetTestClass()));
		
		
	}
	
}
