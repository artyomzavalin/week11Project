import entity.Customer;
import enums.Actions;
import exceptions.UserNotFoundException;
import services.AccountService;
import services.AccountServiceImpl;
import services.CustomerService;
import services.CustomerServiceImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final AccountService ACCOUNT_SERVICE = new AccountServiceImpl();
    private static final CustomerService customerService = new CustomerServiceImpl();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Customer currentUser = null;

        try {
            currentUser = customerService.login();
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());

            return;
        }

        while (true) {
            System.out.println("Choose your action...");
            for (int i = 0; i < Actions.values().length; i++) {
                System.out.println((i + 1) + " - " + Actions.values()[i]);
            }
            try {
                int userChoice = scan.nextInt();
                switch (userChoice) {
                    case 1:
                        ACCOUNT_SERVICE.addFunds(currentUser);
                        break;
                    case 2:
                        ACCOUNT_SERVICE.withdrawMoney(currentUser);
                        break;
                    case 3:
                        ACCOUNT_SERVICE.createAccount(currentUser);
                        break;
                    case 4:
                        ACCOUNT_SERVICE.freezeAccount(currentUser);
                        break;
                    case 5:
                        System.exit(0); // Use 0 to indicate a normal exit.
                    default:
                        System.out.println("Not a valid choice...");
                }
            } catch(InputMismatchException e){
                    System.out.println("Please enter a number.");
                    scan.nextLine();
                }
            }
        }
    }
