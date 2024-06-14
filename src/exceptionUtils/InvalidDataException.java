package exceptionUtils;

public class InvalidDataException extends RuntimeException{

	private static final long serialVersionUID = -1669854034326013685L;

	public InvalidDataException(String message) {
		super(message);
	}

}
