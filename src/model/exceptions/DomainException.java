package model.exceptions;

//public class DomainException extends Exception {
public class DomainException extends RuntimeException {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// classe serializable
	
	
	public DomainException(String msg) {
		super(msg);
	}
	
}
