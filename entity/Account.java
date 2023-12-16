package entity;


import exceptions.NotEnoughFundsException;
import exceptions.WithdrawalNotAllowedException;

public abstract class Account implements Freezable {

    protected int number;
    protected int funds;
    public boolean isFrozen;


    // ------------------------------- Constructor ----------------------------------------------------

    public Account(int number, int funds) {
        this.number = number;
        this.funds = funds;
        this.isFrozen = false;
    }

    // ------------------------------- Methods --------------------------------------------------------------

    public abstract boolean withdraw(int amountToWithdraw ) throws NotEnoughFundsException, WithdrawalNotAllowedException;

    public void addFunds(int amountToAdd){
        this.funds += amountToAdd;
    }

    @Override
    public void freeze() {
        this.isFrozen = true;
    }

    public int getFunds() {
        return funds;
    }

    public int getNumber() {
        return number;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
}
