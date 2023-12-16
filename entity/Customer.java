package entity;


import java.util.List;
import java.util.Random;

public class Customer {

    private String userName;
    private String password;
    private List<Account> accounts;

    private int customerNumber;

    public Customer(String userName, String password, List<Account> accounts, int customerNumber) {
        this.userName = userName;
        this.password = password;
        this.accounts = accounts;
        this.customerNumber = customerNumber;
    }

    // ------------------------------- Methods --------------------------------------------------------------

    public int createAccount(int hesapTuru){
        int newAccountNumber = new Random().nextInt((9999 - 100) + 1) + 10;
        if (hesapTuru == 1){
            this.getAccounts().add(new SavingAccount(newAccountNumber, 0));
        } else{
            this.getAccounts().add(new CheckingAccount(newAccountNumber, 0));
        }

        return newAccountNumber;
    }


    public Account confirmAccountNumber(String chosenAccount)  {

        Integer chosen = Integer.parseInt(chosenAccount);
        for (Account account : this.accounts) {
            if (account.getNumber() == chosen){
                return account;
            }
        }
        return null;
    }



    // ------------------------------- Getters and Setters ----------------------------------------------------

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
