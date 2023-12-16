package exceptions;

public class AccountFrozenException extends Exception {

    public AccountFrozenException(String text) {
        super(text);
    }
}
