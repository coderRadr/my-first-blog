package net.codersadda.myblog.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;

@ControllerAdvice
public class RequestExceptionHandler implements ResponseErrorHandler {
	
	@ExceptionHandler(value = {RequestException.class})
	public void handleRequestException(ClientHttpResponse exp) throws IOException {
		String responseBody = new BufferedReader(new InputStreamReader(exp.getBody()))
				  .lines().collect(Collectors.joining("\n"));
		responseBody = ZonedDateTime.now(ZoneId.of("America/New_York")).toString().concat(responseBody);
		throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, responseBody);
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
		          || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		handleRequestException(response);
		
	}
	
	

}
