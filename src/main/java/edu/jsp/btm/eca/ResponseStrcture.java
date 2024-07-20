package edu.jsp.btm.eca;

public class ResponseStrcture<T> {

	private int statusCode;
	private String message;
	private T data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int sttausCode) {
		this.statusCode = sttausCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String mesaage) {
		this.message = mesaage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
