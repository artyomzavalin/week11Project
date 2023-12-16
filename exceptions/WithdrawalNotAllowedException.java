package exceptions;

public class WithdrawalNotAllowedException extends Exception {
    public WithdrawalNotAllowedException(String message) {
        super(message);
    }
}