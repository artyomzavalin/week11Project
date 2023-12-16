package repository;



import entity.Account;
import entity.CheckingAccount;
import entity.Customer;
import entity.SavingAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {  // Database simulation

    private static Account user_1_account1 = new SavingAccount(1234, 200);
    private static Account user_1_account2 = new CheckingAccount(4321, 20);
    private static Account user_2_account1 = new SavingAccount(5678, 1000);
    private static Account user_2_account2 = new CheckingAccount(8765, 100);



    private static Customer customer1 = new Customer("user1", "1234", new ArrayList<>(Arrays.asList(user_1_account1,user_1_account2)), 00001);
    private static Customer customer2 = new Customer("user2", "1234", new ArrayList<>(Arrays.asList(user_2_account1, user_2_account2)), 00002);
    public static List<Customer> customers = new ArrayList<>(Arrays.asList(customer1,customer2));



    // ------------------------------- Methods --------------------------------------------------------------
    public static Customer confirmUsernameAndPassword(String username, String password) {

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserName().equals(username) && customers.get(i).getPassword().equals(password)){
                return customers.get(i);
            }
        }
        return null;
    }


    public static Customer confirmCustomerNumber(int customerNumber){
        for (Customer customer : customers){
            if (customer.getCustomerNumber() == customerNumber) return customer;
        }
        System.out.println("Customer id not found...");
        return null;
    }
}
