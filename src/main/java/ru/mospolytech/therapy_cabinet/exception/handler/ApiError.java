package ru.mospolytech.therapy_cabinet.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    public ApiError(HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = "Unexpected error";
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }
}
