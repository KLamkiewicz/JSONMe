package convertTo;

import org.junit.Test;

import pl.krzysiek.JSONMe.exceptions.UnreasonableJSONException;
import pl.krzysiek.JSONMe.main.JSONMeObject;

public class UnreasonableTest {
	
	//Unreasonable exceptions
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestInteger() throws Exception{
		JSONMeObject json = new JSONMeObject(4);
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestBoolean() throws Exception{
		JSONMeObject json = new JSONMeObject(true);
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestString() throws Exception{
		JSONMeObject json = new JSONMeObject("test");
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestCharacter() throws Exception{
		JSONMeObject json = new JSONMeObject('s');
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestDouble() throws Exception{
		JSONMeObject json = new JSONMeObject(4.22d);
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestFloat() throws Exception{
		JSONMeObject json = new JSONMeObject(4.22f);
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestByte() throws Exception{
		byte b = 4;
		JSONMeObject json = new JSONMeObject(b);
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestShort() throws Exception{
		short s = 10;
		JSONMeObject json = new JSONMeObject(s);
	}
	
	@Test(expected=UnreasonableJSONException.class)
	public void UnreasonableJSONExceptionTestLong() throws Exception{
		long l = 4;
		JSONMeObject json = new JSONMeObject(l);
	}
}
