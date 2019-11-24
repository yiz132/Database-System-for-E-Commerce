package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.BusinessCustomer;

public interface BusinessCustomerRepository extends CrudRepository<BusinessCustomer, Integer> {
    BusinessCustomer findByName(String name);
}
