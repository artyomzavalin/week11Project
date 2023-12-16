package exceptions;

public class NotEnoughFundsException extends Exception{
    public NotEnoughFundsException(String text) {
        super(text);
    }
}
