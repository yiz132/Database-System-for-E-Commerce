package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team_random.DBProject.model.HomeCustomer;

import java.util.List;
import java.util.Map;

public interface HomeCustomerRepository extends CrudRepository<HomeCustomer, Integer> {
    HomeCustomer findByName(String name);
    HomeCustomer findById(int id);

}
