package team_random.DBProject.service;

import team_random.DBProject.model.RegionManager;

public interface RegionManagerService {
    void save(RegionManager mana);
    RegionManager findByName(String name);
}
