package pl.krzysiek.JSONMe.exceptions;

public class UnreasonableJSONException extends Exception{

	public UnreasonableJSONException() {
		super();
	}
	public UnreasonableJSONException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnreasonableJSONException(String message) {
		super(message);
	}

	public UnreasonableJSONException(Throwable cause) {
		super(cause);
	}

}
