package pl.server.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.server.ErrorCode;


@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(RestException.class)
    public ResponseEntity<Object> handle(RestException exception) {
        return ResponseEntity
                .status(HttpStatus.valueOf(exception.getStatusCode()))
                .body(exception.getEntity());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handle(AccessDeniedException exception) {
        return ResponseEntity
                .status(HttpStatus.valueOf(ErrorCode.UNAUTHORIZED.getStatus().getStatusCode()))
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorCode.UNAUTHORIZED.asEntity());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handle(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.valueOf(ErrorCode.OTHER_ERROR.getStatus().getStatusCode()))
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorCode.OTHER_ERROR.asEntity(exception.getMessage()));
    }
}
