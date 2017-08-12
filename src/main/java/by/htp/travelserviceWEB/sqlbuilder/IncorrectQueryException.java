package by.htp.travelserviceWEB.sqlbuilder;

public class IncorrectQueryException extends RuntimeException {

	private static final long serialVersionUID = 6197453924471075127L;

	public IncorrectQueryException(String message) {
		super(message);
	}
	
	public IncorrectQueryException(Throwable cause) {
		super(cause);
	}
	
	public IncorrectQueryException(String message, Throwable cause) {
		super(message, cause);
	}

}
