package com.example.demo.exception;

import java.util.ArrayList;
import java.util.Map;

public class ValidationOverallResponse {
private Map<String, ArrayList<ValidationErrorResponse>> fieldLevelErrors;

public Map<String, ArrayList<ValidationErrorResponse>> getFieldLevelErrors() {
	return fieldLevelErrors;
}

public void setFieldLevelErrors(Map<String, ArrayList<ValidationErrorResponse>> fieldLevelErrors) {
	this.fieldLevelErrors = fieldLevelErrors;
}





}
