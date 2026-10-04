package br.com.isaacpatrocinio.library_api.controllers.exceptionhandler;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class StandardError {

    private Instant timestamp;
    private HttpStatus status;
    private String error;

    public StandardError() {
    }

    public StandardError(Instant timestamp, HttpStatus status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
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
