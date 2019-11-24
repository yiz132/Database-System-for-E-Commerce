package team_random.Backend.service;

import team_random.Backend.model.HomeCustomer;
import team_random.Backend.model.Login;

public interface HomeCustomerService {
    public void register(HomeCustomer customer);
    public HomeCustomer validateCustomer(Login login);
}
