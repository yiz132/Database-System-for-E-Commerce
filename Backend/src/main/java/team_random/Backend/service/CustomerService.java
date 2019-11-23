package team_random.Backend.service;

import team_random.Backend.model.Customer;
import team_random.Backend.model.Login;

public interface CustomerService {
    public void register(Customer customer);
    public Customer validateCustomer(Login login);
}
