package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

//요청한 url을 처리하면서 나오는 예외를 처리해 주는 클래스
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	//예외를 처리하는 메서드 ->예외의 종류가 Exception인 것은 처리
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex, Model model) {
		log.error("Exception .........." + ex.getMessage());
		model.addAttribute("exception", ex); //jsmp에서는 ${exception}으로 찾음
		return "error_page";
	}
}
