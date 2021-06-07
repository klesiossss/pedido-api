package br.com.bluesoft.desafio.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.bluesoft.desafio.view.ErroView;

@RestController
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	 @ResponseStatus(INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(Exception.class)
	    public ErroView handleException(Exception ex) {
	        return new ErroView(ex.getMessage());
	    }

	@ExceptionHandler({ BusinessException.class })
    public ResponseEntity<Object> handleDuplicatedEntityException(BusinessException ex, WebRequest request) {
		ExceptionMessage exception = new ExceptionMessage(ex.getMessage(), HttpStatus.BAD_REQUEST, null);
        return handleExceptionInternal(ex, exception, new HttpHeaders(), exception.getStatusCode(), request);
}

	
	
}
