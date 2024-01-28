package Board.bt.exception;

public class NoSuchIdxException extends RuntimeException{
    public NoSuchIdxException() {
        super();
    }

    public NoSuchIdxException(String message) {
        super(message);
    }

    public NoSuchIdxException(String message, Throwable cause) {
        super(message, cause);
    }
}
