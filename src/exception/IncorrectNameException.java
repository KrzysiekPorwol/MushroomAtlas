package exception;

public class IncorrectNameException extends RuntimeException {
  public IncorrectNameException(String message) {
    super(message);
  }
}
