package com.dogiant.springboot.demo.web.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dogiant.springboot.demo.domain.dto.HttpResult;
import com.dogiant.springboot.demo.exception.CommException;

@RestControllerAdvice
public class CommExceptionHandler {

	@ExceptionHandler(value = CommException.class)
	@ResponseBody
	public HttpResult<String> jsonErrorHandler(HttpServletRequest req, CommException e) throws Exception {
		HttpResult<String> result = HttpResult.newResult(e.getCode(), e.getMessage());
		result.setData("Some Data");
		return result;
	}
}
