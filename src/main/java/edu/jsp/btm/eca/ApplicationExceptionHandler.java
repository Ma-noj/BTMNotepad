package edu.jsp.btm.eca;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotePadIdNotFoundException.class)
	public ResponseEntity<ResponseStrcture<String>> handleNotePadIdNotFoundException(
			NotePadIdNotFoundException exception) {

		ResponseStrcture<String> responseStrcture = new ResponseStrcture<String>();
		responseStrcture.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStrcture.setMessage(exception.getMessage());

		return new ResponseEntity<ResponseStrcture<String>>(responseStrcture, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvaliedPhoneNumberException.class)
	public ResponseEntity<ResponseStrcture<String>> handleInvaliedPhoneNumberException(
			InvaliedPhoneNumberException exception) {
		ResponseStrcture<String> strcture = new ResponseStrcture<String>();
		strcture.setStatusCode(HttpStatus.BAD_REQUEST.value());
		strcture.setMessage(exception.getMessage());
		return new ResponseEntity<ResponseStrcture<String>>(strcture,HttpStatus.BAD_REQUEST);
	}
}
