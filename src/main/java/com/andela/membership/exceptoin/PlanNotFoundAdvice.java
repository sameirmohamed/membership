package com.andela.membership.exceptoin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PlanNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(PlanNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(PlanNotFoundException ex) {
		return ex.getMessage();
	}

}
