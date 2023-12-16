package entity;

import exceptions.NotEnoughFundsException;
import exceptions.WithdrawalNotAllowedException;

import java.time.LocalDate;

public class SavingAccount extends Account {

    public LocalDate savingStartTime;

    public SavingAccount(int number, int funds) {
        super(number, funds);
        savingStartTime = LocalDate.now();
    }
    public boolean isWithdrawalAllowed() {
        return !LocalDate.now().isBefore(savingStartTime.plusYears(1));
    }
    @Override
    public boolean withdraw(int amountToWithdraw)throws NotEnoughFundsException,WithdrawalNotAllowedException{


        if (!isWithdrawalAllowed()) {
            throw new WithdrawalNotAllowedException("Cannot withdraw money from Saving Account before one year.");
        }


        if (this.getFunds() < amountToWithdraw) {
            throw new NotEnoughFundsException("Not enough funds to perform the withdrawal.");
        }

        // TODO Else If there is not enough money in the account, throw an exception....
        this.setFunds(getFunds() - amountToWithdraw);
        System.out.println("There are "+getFunds()+"$ left in your account...");
        return true;
    }


}
