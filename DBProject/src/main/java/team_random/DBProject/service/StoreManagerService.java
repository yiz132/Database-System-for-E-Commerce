package team_random.DBProject.service;

import team_random.DBProject.model.Store;
import team_random.DBProject.model.StoreManager;
import team_random.DBProject.model.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StoreManagerService {
    void save(StoreManager manager);
    StoreManager findById(int store_manager_id);
    StoreManager findByName(String name);
    List<Transaction> findByStoreId(int storeId);
    List<Map<String,String>> reviewAllByStoreManager(int store_mana_id);

    List<Map<String, String>> searchProductsByKeywords(int id, String search_keyword);
}
