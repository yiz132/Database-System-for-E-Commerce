package team_random.Backend.dao;

import org.springframework.data.repository.CrudRepository;
import team_random.Backend.model.Customer;
import team_random.Backend.model.Login;

import java.io.Serializable;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
    public void register(Customer customer);

    public Customer validateCustomer(Login login);
}
