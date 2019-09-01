package com.sh.validator.app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sh.validator.app.FunctionalException;

@ControllerAdvice
public class HandlerExceptions extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
		
		List<String> lsErrors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		
		body.put("errors", lsErrors);
		body.put("status", status.value());
		
		return new ResponseEntity<Object>(body, status);
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> handlerException(Exception ex){
		
		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("error", ex.getMessage());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FunctionalException.class)
	private ResponseEntity<Object> handlerException(FunctionalException ex){
		
		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("error", ex.getMessage());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}
	
}
