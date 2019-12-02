package team_random.DBProject.service;

import team_random.DBProject.model.Store;

import java.util.List;

public interface StoreService {
    void save(Store store);
    Store findById(int id);
    List<String> findAllNames();
}
