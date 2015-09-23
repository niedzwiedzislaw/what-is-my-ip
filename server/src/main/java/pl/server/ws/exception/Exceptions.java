package pl.server.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Exceptions {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class InternalServerError extends RuntimeException { }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public static class Unauthorized extends RuntimeException { }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public static class Forbidden extends RuntimeException { }
}
