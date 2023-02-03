package com.example.TaxTechExam.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.TaxTechExam.enumeration.StatusEnum;
import com.example.TaxTechExam.exception.InternalErrorException;
import com.example.TaxTechExam.response.StatusResponse;

@RestControllerAdvice
public class ClientAdvice extends ResponseEntityExceptionHandler{
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
								.map(FieldError::getDefaultMessage)
								.collect(Collectors.toList());
		StatusResponse result = StatusResponse.builder()
								.code(StatusEnum.FAIL.getStatus().getCode())
								.message(StatusEnum.FAIL.getStatus().getMessage())
								.errors(errors)
								.build();
		
		return new ResponseEntity<>(result,status);
	}



	@ExceptionHandler
	public ResponseEntity<?> runtime(InternalErrorException ex){
		
		StatusResponse response = StatusResponse.builder()
									.code(ex.getStatusResponse().getCode())
									.message(ex.getStatusResponse().getMessage())
									.build();
		
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
