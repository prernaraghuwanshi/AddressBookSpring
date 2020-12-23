package com.bl.addrbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> handle(ContactException ex) {
		if(ex instanceof NotFoundException) {
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		if(ex instanceof BadRequestException) {
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
