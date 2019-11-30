package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Salesperson;

public interface SalespersonRepository extends CrudRepository<Salesperson, Integer> {
    Salesperson findByName(String name);
}
