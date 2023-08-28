package com.test.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.test.controller.dto.ErrorResponseGeneral;
import com.test.controller.dto.ResponseError;
import com.test.controller.dto.Violiation;

@ControllerAdvice
public class ExceptionHandlerAdvice implements ResponseBodyAdvice<Object> {
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> onArgumntValidationException(MethodArgumentNotValidException ex) {       
        ResponseError responseError=new ResponseError();
        responseError.setCodigo(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        ex.getBindingResult().getFieldErrors().forEach((error) -> {     
            responseError.getViolations().add(new Violiation(error.getField(), error.getDefaultMessage()));
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> validationException(ConstraintViolationException ex) {       
    	ResponseError responseError=new ResponseError();
    	responseError.setCodigo(String.valueOf(HttpStatus.BAD_REQUEST.value()));
    	ex.getConstraintViolations().forEach((error) -> {     
    		responseError.getViolations().add(new Violiation(error.getPropertyPath().toString(), error.getMessage()));
    	});
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseGeneral> validationException(Exception  ex) {       
    	ErrorResponseGeneral responseError=new ErrorResponseGeneral();
    	responseError.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
    	responseError.setMessage(ex.getMessage());
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		return body;
	}
}
