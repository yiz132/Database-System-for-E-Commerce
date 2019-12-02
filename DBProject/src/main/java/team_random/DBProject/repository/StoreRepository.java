package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {
    Store findById(int id);
}
