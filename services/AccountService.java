package services;

import entity.Account;
import entity.Customer;
import exceptions.AccountFrozenException;
import exceptions.AccountNotFoundException;
import exceptions.NotEnoughFundsException;

public interface AccountService {

    Account getAccountByCustomer(Customer currentUser) throws AccountFrozenException, AccountNotFoundException;

    void addFunds(Customer currentUser);

    void withdrawMoney(Customer currentUser);

    void createAccount(Customer currentUser);

    void freezeAccount(Customer currentUser);

}
