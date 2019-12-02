package team_random.DBProject.service;

import team_random.DBProject.model.Region;

public interface RegionService {
    void save(Region region);
    Region findByName(String name);
    Region findById(int id);
}
