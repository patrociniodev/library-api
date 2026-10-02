package br.com.isaacpatrocinio.library_api.controllers.exceptionhandler;

import br.com.isaacpatrocinio.library_api.services.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(Exception e) {
        StandardError errorObj = new StandardError();
        HttpStatus notFoundStatus = HttpStatus.valueOf(404);

        errorObj.setTimestamp(Instant.now());
        errorObj.setStatus(notFoundStatus);
        errorObj.setError(e.getMessage());
        errorObj.setMessage("Recurso não encontrado.");

        return ResponseEntity.status(notFoundStatus).body(errorObj);
    }
}
