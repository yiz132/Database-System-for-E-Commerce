package team_random.DBProject.service;

import team_random.DBProject.model.Store;

public interface StoreService {
    void save(Store store);
    Store findById(int id);
}
