package team_random.DBProject.repository;

import org.springframework.data.repository.CrudRepository;
import team_random.DBProject.model.RegionManager;

public interface RegionManagerRepository extends CrudRepository<RegionManager, Integer> {
    RegionManager findByName(String name);
}
