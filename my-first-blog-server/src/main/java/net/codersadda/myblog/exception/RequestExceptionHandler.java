package net.codersadda.myblog.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {
	
	@ExceptionHandler(value = {RequestException.class})
	public ResponseEntity<Object> handleRequestException(RequestException e) {
		RequestExceptionBody exceptionBody = new RequestExceptionBody(e.getMessage(), e, HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("America/New_York")));
		return new ResponseEntity<>(exceptionBody, HttpStatus.BAD_REQUEST);
	}

}
