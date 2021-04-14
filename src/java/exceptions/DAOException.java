package exceptions;

public class DAOException extends Exception {

	/** Excepcion con mensaje */
	public DAOException(String message) {
		super(message);
	}

	/** Excepcion con mensaje y causa */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
