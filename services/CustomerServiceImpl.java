package services;

import entity.Customer;
import exceptions.UserNotFoundException;
import repository.Database;

public class CustomerServiceImpl extends AbstractService implements CustomerService {


    @Override
    public Customer login() throws UserNotFoundException {
        Customer currentUser;
        // TODO Add a counter in here,
        int passCount = 0;
        while (true) {
            System.out.println("Please enter your username: ");
            String username = scan.nextLine();
            System.out.println("Please enter your password: ");
            String password = scan.nextLine();


            currentUser = Database.confirmUsernameAndPassword(username, password);
            if (currentUser != null) {
                System.out.println("Login Success");
                return currentUser;

            } else {
                passCount++;
                if (passCount >= 3) {
                    throw new UserNotFoundException("No user found with this credentials!");


                    // TODO When user enters 3 times wrong username and password... throw exception...
                }
            }
        }
    }
}




