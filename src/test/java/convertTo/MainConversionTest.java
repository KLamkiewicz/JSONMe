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

//	@Test(expected=NoDataToConvertException.class)
//	public void NoDataToConvertExceptionTest() throws Exception{
//		JSONMeObject json = new JSONMeObject(null);
//	}
//	
//	@Test
//	public void printStringTest() throws NoDataToConvertException, UnreasonableJSONException{
//		JSONMeObject json = new JSONMeObject(new PersonTestClass());
//		System.out.println(json.getJSON());
//	}
//	
//	@Test
//	public void emptyClassTest() throws NoDataToConvertException, UnreasonableJSONException {
//		JSONMeObject json = new JSONMeObject(new EmptyClass());
//		assertTrue(json.getJSON().equals("null"));
//		
//	}
//	
//	@Test
//	public void listClassTest() throws NoDataToConvertException, UnreasonableJSONException {
//		JSONMeObject json = new JSONMeObject(new StreetTestClass());
//		System.out.println(json.getJSON());
//		
//	}
	
	@Test
	public void staticTest() throws NoDataToConvertException, UnreasonableJSONException{
		//System.out.println(JSONMeObject.getJSON(new PersonTestClass()));
		System.out.println(JSONMeObject.getJSON(new PersonTestClass()));
		System.out.println(JSONMeObject.getJSON(new StreetTestClass()));
		System.out.println(JSONMeObject.getJSON(new PersonTestClass()));
	}
	
}
