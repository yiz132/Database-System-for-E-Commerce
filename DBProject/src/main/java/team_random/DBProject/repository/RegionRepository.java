package team_random.DBProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Region;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Integer> {
    Region findByName(String name);
    Region findById(int id);
    @Query(value = "SELECT DISTINCT name FROM regions ", nativeQuery = true)
    List<String> findAllNames();
}
