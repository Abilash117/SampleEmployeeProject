package com.example.demo.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = EntityValidationException.class)
	@ResponseBody
	public ResponseEntity<ValidationOverallResponse> handleMetohdArugument(EntityValidationException ex) {
		Map<String, ArrayList<ValidationErrorResponse>> errorResponse = new LinkedHashMap<>();
		int errorCode = 0;
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errorCode = errorCode + 1;
			ArrayList<ValidationErrorResponse> validationList = new ArrayList<ValidationErrorResponse>();
			validationList.add(new ValidationErrorResponse(error.getDefaultMessage(), errorCode));
			errorResponse.put(error.getField(), validationList);
		}
		ValidationOverallResponse overAllResponse = new ValidationOverallResponse();
		overAllResponse.setFieldLevelErrors(errorResponse);
		return new ResponseEntity<ValidationOverallResponse>(overAllResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EntityExistsNotExistsException.class)
	@ResponseBody
	public ResponseEntity<ValidationErrorResponse> employeeExsists(EntityExistsNotExistsException ex) {
		return new ResponseEntity<ValidationErrorResponse>(new ValidationErrorResponse(ex.getErrorMessage(), 1), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity exception(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
