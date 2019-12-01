package team_random.DBProject.service;

import team_random.DBProject.model.StoreManager;
import team_random.DBProject.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface StoreManagerService {
    void save(StoreManager manager);
    StoreManager findByName(String name);
    List<Transaction> findByStoreId(int storeId);
}
