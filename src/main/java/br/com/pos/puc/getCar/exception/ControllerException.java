package br.com.pos.puc.getCar.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
@RestController
public class ControllerException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionDto> handlerNotFoundException(NotFoundException ex){
		ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), ex.getDetalhes());
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.NOT_FOUND);
	}
	
	

//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = {Exception.class, Throwable.class, AuthenticationException.class})
//	public String handle(Exception exception, AuthenticationException autException) {
//		return exception.getMessage();
//		
//	}
//	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(value = {BadRequest.class})
//	public String badRequestException(BadRequest bdRequestException) {
//		return bdRequestException.getMessage();
//	}
}
