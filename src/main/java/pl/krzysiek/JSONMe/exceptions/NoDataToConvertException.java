package pl.krzysiek.JSONMe.exceptions;

public class NoDataToConvertException extends Exception{

	public NoDataToConvertException() {
		super();
	}

	public NoDataToConvertException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoDataToConvertException(String message) {
		super(message);
	}

	public NoDataToConvertException(Throwable cause) {
		super(cause);
	}

}
