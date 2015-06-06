package reverseString;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;
	public String message;
	
	public InvalidInputException(){}
	public InvalidInputException(String message) {
		this.message = message;
	}
}