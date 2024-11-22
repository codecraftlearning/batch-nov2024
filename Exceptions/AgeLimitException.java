package Exceptions;

public class AgeLimitException extends RuntimeException {
    public AgeLimitException(String message) {
        super(message);
    }

    public static AgeLimitException lessThan18NotAllowed() {
        return new AgeLimitException("Age limit must be more than 18");
    }
}
