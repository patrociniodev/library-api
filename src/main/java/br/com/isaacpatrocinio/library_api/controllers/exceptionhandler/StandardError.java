package br.com.isaacpatrocinio.library_api.controllers.exceptionhandler;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.ZonedDateTime;

public class StandardError {

    private ZonedDateTime timestamp;
    private HttpStatus status;
    private String error;

    public StandardError() {
    }

    public StandardError(ZonedDateTime timestamp, HttpStatus status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
