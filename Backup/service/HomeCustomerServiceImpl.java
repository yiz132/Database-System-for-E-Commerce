package team_random.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import team_random.Backend.repository.HomeCustomerDao;
import team_random.Backend.model.HomeCustomer;
import team_random.Backend.model.Login;

public class HomeCustomerServiceImpl implements HomeCustomerService {
    @Autowired
    public HomeCustomerDao homeCustomerDao;
    @Override
    public void register(HomeCustomer customer) {
        homeCustomerDao.register(customer);
    }

    @Override
    public HomeCustomer validateCustomer(Login login) {
        return homeCustomerDao.validateCustomer(login);
    }
}
