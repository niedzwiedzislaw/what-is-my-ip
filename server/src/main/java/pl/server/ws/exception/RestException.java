package pl.server.ws.exception;

import pl.server.ErrorCode;

public class RestException extends RuntimeException {
    private ErrorCode errorCode;
    private Object[] parameters;

    RestException(ErrorCode errorCode) {
        this(errorCode, new Object[]{});
    }

    RestException(ErrorCode errorCode, Object... parameters) {
        this.errorCode = errorCode;
        this.parameters = parameters;
    }

    public int getStatusCode() {
        return errorCode.getStatus().getStatusCode();
    }

    public ErrorCode.Entity getEntity() {
        return errorCode.asEntity(parameters);
    }
}
