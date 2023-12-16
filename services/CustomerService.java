package services;


import entity.Customer;
import exceptions.UserNotFoundException;

public interface CustomerService {

    Customer login() throws UserNotFoundException;
}
