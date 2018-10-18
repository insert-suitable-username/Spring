package com.ps.rest.exception_processors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ps.rest.exceptions.JsonError;
import com.ps.rest.exceptions.UserException;

@ControllerAdvice
public class RestExceptionProcessor {

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public JsonError exception(UserException ex) {
		return new JsonError(ex.getMessage());
	}
}
