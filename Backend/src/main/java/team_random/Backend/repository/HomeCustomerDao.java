package team_random.Backend.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.Backend.model.HomeCustomer;

public interface HomeCustomerDao extends CrudRepository<HomeCustomer, Integer> {
    /*public void register(HomeCustomer home_customer);

    public HomeCustomer validateCustomer(Login login);

     */
}
