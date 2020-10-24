package br.com.jonataslaet.controller.erro;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ObjectNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(ObjectNotFoundException ex){
		Erro apiError = new Erro("O recurso solicitado não foi encontrado", HttpStatus.NOT_FOUND);
		return construtorDaEntidadeResposta(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Erro erroDeApi = new Erro("O campo deve ser válido", HttpStatus.BAD_REQUEST);
		return construtorDaEntidadeResposta(erroDeApi);
	}
	
	private ResponseEntity<Object> construtorDaEntidadeResposta(Erro erroDeApi){
		return new ResponseEntity<>(erroDeApi, erroDeApi.getStatusHttp());
	}
}
