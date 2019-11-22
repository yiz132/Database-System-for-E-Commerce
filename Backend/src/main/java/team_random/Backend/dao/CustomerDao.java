package team_random.Backend.dao;

import org.springframework.data.repository.CrudRepository;
import team_random.Backend.model.Customer;

import java.io.Serializable;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
