package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Store;

import java.util.List;

public interface StoreRepository extends CrudRepository<Store, Integer> {
    Store findById(int id);
    Store findByName(String name);
    @Query(value = "SELECT DISTINCT name FROM stores ", nativeQuery = true)
    List<String> findAllNames();
}
