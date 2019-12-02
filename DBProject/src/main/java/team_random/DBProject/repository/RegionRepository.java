package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.Region;

public interface RegionRepository extends CrudRepository<Region, Integer> {
    Region findByName(String name);
    Region findById(int id);
}
