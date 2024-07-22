package edu.jsp.btm.eca;

public class NotePadIdNotFoundException extends RuntimeException {
	private String message;

	public NotePadIdNotFoundException(String message) {
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
