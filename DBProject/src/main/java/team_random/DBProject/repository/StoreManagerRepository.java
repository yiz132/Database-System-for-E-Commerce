package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.StoreManager;

public interface StoreManagerRepository  extends CrudRepository<StoreManager, Integer> {
    StoreManager findByName(String name);
}
