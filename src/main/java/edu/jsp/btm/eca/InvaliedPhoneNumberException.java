package edu.jsp.btm.eca;

public class InvaliedPhoneNumberException extends RuntimeException {
	private String message;

	public InvaliedPhoneNumberException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
