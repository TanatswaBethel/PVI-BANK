package za.co.pviBank.servlets.employees;

public class InvalidValueException extends Exception {
	
	
	private static final String MESSAGE = "Invalid value";


	public InvalidValueException() {
		super(MESSAGE);
		
	}


	public InvalidValueException(String message) {
		super(message);
		
	}

	
	

}
