package team_random.DBProject.service;

import team_random.DBProject.model.Region;

import java.util.List;

public interface RegionService {
    void save(Region region);
    Region findByName(String name);
    List<String> findAllNames();
    Region findById(int id);
}
