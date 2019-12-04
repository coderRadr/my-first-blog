package net.codersadda.myblog.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class ExceptionHandler extends RuntimeException implements ResponseErrorHandler{

	private static final Logger log = LogManager.getLogger(ExceptionHandler.class);
	private static final String ERRORTAG = "Error in ";
	
	public ExceptionHandler() {
		super();
	}

	public ExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionHandler(String message, Throwable cause) {
		throw new RestClientException(ERRORTAG+ message);
	}

	public ExceptionHandler(String message) {
		log.error(message);
		throw new RestClientException(ERRORTAG+ message);
	}

	public ExceptionHandler(Throwable cause) {
		log.error(cause.getMessage());
		throw new RestClientException(ERRORTAG + ((Exception) cause).getLocalizedMessage());
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		log.error(response.getBody());
		throw new RestClientException(ERRORTAG+ ((RestClientException) response).getLocalizedMessage());
	}

}
