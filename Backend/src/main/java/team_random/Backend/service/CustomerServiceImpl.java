package team_random.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import team_random.Backend.dao.CustomerDao;
import team_random.Backend.model.Customer;
import team_random.Backend.model.Login;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerDao customerDao;
    @Override
    public void register(Customer customer) {
        customerDao.register(customer);
    }

    @Override
    public Customer validateCustomer(Login login) {
        return customerDao.validateCustomer(login);
    }
}
