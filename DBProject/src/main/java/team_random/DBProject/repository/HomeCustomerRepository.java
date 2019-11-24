package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.HomeCustomer;

public interface HomeCustomerRepository extends CrudRepository<HomeCustomer, Integer> {
    HomeCustomer findByName(String name);
}
