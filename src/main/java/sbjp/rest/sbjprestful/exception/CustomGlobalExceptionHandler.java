package sbjp.rest.sbjprestful.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorReponse> customBookNotFound(Exception ex, WebRequest request) {
		CustomErrorReponse errors = new CustomErrorReponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		errors.setError(ex.getMessage());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}

}