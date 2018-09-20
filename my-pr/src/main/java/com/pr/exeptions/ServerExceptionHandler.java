package com.pr.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.pr.constants.ErrorMessages;
import com.pr.domain.response.ErrorMessage;

@ControllerAdvice
public class ServerExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessages> handleExceptions(Exception e, WebRequest req){
		ErrorMessages errorMessage = new ErrorMessages(e.getMessage());
		return new ResponseEntity<ErrorMessages>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = UserServiceException.class)
	public ResponseEntity<ErrorMessages> handleUserServiceException(UserServiceException e, WebRequest req){
		ErrorMessages errorMessage = new ErrorMessages(e.getMessage());
		return new ResponseEntity<ErrorMessages>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessages> hadleCommodityNotFoundException(UserServiceException e, WebRequest req){
		ErrorMessage errorMessage = new ErrorMessages(e.getMessage());
		return new ResponseEntity<ErrorMessages>(errorMessage, HttpStatus.NO_CONTENT);
	}
}
