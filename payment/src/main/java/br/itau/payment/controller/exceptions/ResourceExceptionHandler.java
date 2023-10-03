package br.itau.payment.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> badRequest(Exception e, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Requisição inválida. Por favor, verifique os dados enviados e tente novamente.");
        error.setPath(request.getRequestURI());
        error.setError("Requisição inválida");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
