package pl.server.ws.exception;

import pl.server.ErrorCode;

public class RestExceptionFactory {
    public static RestException Generic() {
        return new RestException(ErrorCode.GENERIC_ERROR);
    }

    public static RestException ParseDate(String date) {
        return new RestException(ErrorCode.CANNOT_PARSE_DATE, date);
    }

    public static RestException UnsupportedArgument(String message) {
        return new RestException(ErrorCode.UNSUPPORTED_ARGUMENT, message);
    }

    public static RestException Unauthorized() {
        return new RestException(ErrorCode.UNAUTHORIZED);
    }
}
