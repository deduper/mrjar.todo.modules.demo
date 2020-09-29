package works.hop.todo.feature.api;

public class FeatureException extends RuntimeException{

    public FeatureException(String message) {
        super(message);
    }

    public FeatureException(String message, Throwable cause) {
        super(message, cause);
    }
}
