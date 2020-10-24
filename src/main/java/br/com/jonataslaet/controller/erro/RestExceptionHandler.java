package br.com.jonataslaet.controller.erro;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(ObjectNotFoundException ex){
		Erro apiError = new Erro("O recurso solicitado não foi encontrado", HttpStatus.NOT_FOUND);
		return construtorDaEntidadeResposta(apiError);
	}
	
	private ResponseEntity<Object> construtorDaEntidadeResposta(Erro erroDeApi){
		return new ResponseEntity<>(erroDeApi, erroDeApi.getStatusHttp());
	}
}
