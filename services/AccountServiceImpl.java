package services;

import entity.Account;
import entity.Customer;
import entity.SavingAccount;
import exceptions.AccountFrozenException;
import exceptions.NotEnoughFundsException;
import exceptions.AccountNotFoundException;
import exceptions.WithdrawalNotAllowedException;

public class AccountServiceImpl extends AbstractService implements AccountService {

    public Account getAccountByCustomer(Customer currentUser) throws AccountFrozenException,AccountNotFoundException {
        Account chosenAccount;
        System.out.println("Enter Account Number...: ");
        for (Account account : currentUser.getAccounts()) {
            System.out.println(account.getNumber());
        }
        String chosen = scan.next();
        chosenAccount = currentUser.confirmAccountNumber(chosen);
        if (chosenAccount == null) {

           throw new AccountNotFoundException("Account not found");

        } else if (chosenAccount.isFrozen) {


            throw new AccountFrozenException("Frozen account cannot be used");
        }


        // TODO Else if account is Frozen, throw an exception...

        return chosenAccount;
    }

    @Override
    public void addFunds(Customer customer) {
        try {
            Account chosenAccount = getAccountByCustomer(customer);
            System.out.println("Enter Amount...: ");
            int amountToAdd = scan.nextInt();
            chosenAccount.addFunds(amountToAdd);
        } catch (AccountNotFoundException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdrawMoney(Customer currentUser) {
        while (true) {
            try {
                Account chosenAccount = getAccountByCustomer(currentUser);
                if (chosenAccount instanceof SavingAccount savingAccount) {
                    if (!savingAccount.isWithdrawalAllowed()) {
                        throw new WithdrawalNotAllowedException("Cannot withdraw money from Saving Account before one year.");
                    }
                }
                System.out.println("Enter Amount...: ");
                int amountToWithdraw = scan.nextInt();
                if (chosenAccount.withdraw(amountToWithdraw)) {
                    break;
                }
            } catch (AccountNotFoundException e) {
                System.out.println(e.getMessage());

            } catch (AccountFrozenException e) {
                System.out.println(e.getMessage());
                return;

            } catch (NotEnoughFundsException | WithdrawalNotAllowedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    @Override
    public void createAccount(Customer currentUser) {
        System.out.println("Confirm Account Opening?.. Y / N");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter : 1 - Saving, 2 - Checking: ");
            int accountType = scan.nextInt();
            System.out.println("Account created with number :" + currentUser.createAccount(accountType));
            return;
        }
        System.out.println("Not valid choice...");
    }

    @Override
    public void freezeAccount(Customer currentUser) {
        try {
            Account chosenAccount = getAccountByCustomer(currentUser);
            chosenAccount.freeze();
            System.out.println("Account frozen...");
        } catch (AccountNotFoundException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
    }
}