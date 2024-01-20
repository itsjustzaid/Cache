package exception;

public class StorageFull extends RuntimeException {
    public StorageFull(String message) {
        super(message);
    }
}
