package com.healthcare.exception;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.healthcare.service.ExceptionHealth;


@RestControllerAdvice
public class HealthCareControllerException {
	
	@ResponseStatus(code=HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(ExceptionHealth.class)
	public Map handleMethodArgumentException(ExceptionHealth ex){
		Map<String, String> exe=new HashMap<>();
		exe.put("Message", ex.getMessage());
		return exe; 
	}
}
