package entity;


import exceptions.NotEnoughFundsException;
import exceptions.UserNotFoundException;

public class CheckingAccount extends Account {


    public CheckingAccount(int number, int funds) {
        super(number, funds);
    }

    @Override
    public boolean withdraw(int amountToWithdraw) throws NotEnoughFundsException {
        if (this.getFunds() < amountToWithdraw) {
            throw new NotEnoughFundsException("Not enough funds to perform the withdrawal.");
        }

        this.setFunds(this.getFunds() - amountToWithdraw);
        System.out.println("Withdrawal successful. There are " + this.getFunds() + "$ left in your account.");
        return true;
    }
}
