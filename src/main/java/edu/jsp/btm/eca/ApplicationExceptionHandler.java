package edu.jsp.btm.eca;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApplicationExceptionHandler {
	@ExceptionHandler(NotePadIdNotFoundException.class)
	public ResponseEntity<ResponseStrcture<String>> handleNotePadIdNotFoundException(
			NotePadIdNotFoundException exception) {

		ResponseStrcture<String> responseStrcture = new ResponseStrcture<String>();
		responseStrcture.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStrcture.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStrcture<String>>(responseStrcture, HttpStatus.BAD_REQUEST);
	}
}
