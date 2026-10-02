package br.com.isaacpatrocinio.library_api.controllers.exceptionhandler;

import br.com.isaacpatrocinio.library_api.services.exceptions.LibraryException;
import br.com.isaacpatrocinio.library_api.services.exceptions.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.ZoneId;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(NotFoundException e) {
        StandardError errorObj = new StandardError();
        HttpStatus status = HttpStatus.valueOf(404);
        errorObj.setTimestamp(Instant.now().atZone(ZoneId.systemDefault()));
        errorObj.setStatus(status);
        errorObj.setError("Recurso não encontrado.");

        return ResponseEntity.status(status).body(errorObj);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<StandardError> misspelledId(TypeMismatchException e) {
        StandardError errorObj = new StandardError();
        HttpStatus status = HttpStatus.valueOf(400);
        errorObj.setTimestamp(Instant.now().atZone(ZoneId.systemDefault()));
        errorObj.setStatus(status);
        errorObj.setError("Id passado como parâmetro é inválido.");

        return ResponseEntity.status(status).body(errorObj);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> misspelledJson(HttpMessageNotReadableException e) {
        StandardError errorObj = new StandardError();
        HttpStatus status = HttpStatus.valueOf(400);
        errorObj.setTimestamp(Instant.now().atZone(ZoneId.systemDefault()));
        errorObj.setStatus(status);
        errorObj.setError("Ocorreu um erro com o conteúdo enviado no corpo da requisição.");

        return ResponseEntity.status(status).body(errorObj);
    }
}
