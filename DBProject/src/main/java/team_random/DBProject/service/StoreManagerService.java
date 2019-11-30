package team_random.DBProject.service;

import team_random.DBProject.model.StoreManager;

public interface StoreManagerService {
    void save(StoreManager manager);
    StoreManager findByName(String name);
}
