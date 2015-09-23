package pl.server;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static javax.ws.rs.core.Response.Status;

public enum ErrorCode {
    GENERIC_ERROR(Status.INTERNAL_SERVER_ERROR, 0, "Generic error"),
    UNAUTHORIZED(Status.UNAUTHORIZED, 1, "Please log in first"),
    WRONG_CREDENTIALS(Status.UNAUTHORIZED, 2, "Wrong credentials given"),
    UNSUPPORTED_ARGUMENT(Status.BAD_REQUEST, 3, "Unsupported argument: %s"),
    CANNOT_PARSE_DATE(Status.BAD_REQUEST, 4, "Cannot parse date: %s"),
    OTHER_ERROR(Status.BAD_REQUEST, 5, "Other error: %s");

    private static Set<Integer> codes;

    private Status status;
    private String message;
    private int code;

    ErrorCode(Status status, String message) {
        synchronized (ErrorCode.class) {
            this.status = status;
            int code = getCodes().stream().max(Comparator.naturalOrder()).get() + 1;
            this.code = code;
            this.message = message;
            getCodes().add(code);
        }
    }

    ErrorCode(Status status, int internalCode, String message) {
        synchronized (ErrorCode.class) {
            if (!getCodes().add(internalCode))
                throw new IllegalArgumentException("Given internalCode is not unique: " + internalCode);
            this.code = internalCode;
            this.status = status;
            this.message = message;
        }
    }

    public static Set<Integer> getCodes() {
        if (codes == null) {
            synchronized (ErrorCode.class) {
                if (codes == null) {
                    codes = new HashSet<>();
                }
            }
        }
        return codes;
    }

    public Integer getInternalCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public Entity asEntity() {
        return asEntity(new Object[]{});
    }

    public Entity asEntity(Object... parameters) {
        return new Entity(getInternalCode(), String.format(getMessage(), parameters));
    }

    public static class Entity {
        private int internalCode;
        private String message;

        private Entity(int internalCode, String message) {
            this.internalCode = internalCode;
            this.message = message;
        }

        public int getInternalCode() {
            return internalCode;
        }

        public String getMessage() {
            return message;
        }
    }
}
