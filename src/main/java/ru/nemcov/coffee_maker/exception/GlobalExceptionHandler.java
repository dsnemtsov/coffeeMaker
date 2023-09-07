package ru.nemcov.coffee_maker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nemcov.coffee_maker.util.GlobalError;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GlobalError> handleAccessTokenException(IllegalArgumentException exception) {
        return handleException(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<GlobalError> handleException(Exception exception, HttpStatus errorStatus) {
        Throwable cause = exception.getCause();
        if (cause == null) {
            return ResponseEntity.status(errorStatus)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new GlobalError(exception.getMessage()));
        } else {
            return ResponseEntity.status(errorStatus)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new GlobalError(exception.getMessage() + cause.getMessage()));
        }
    }
}
