package team_random.DBProject.service;

import team_random.DBProject.model.Transaction;

import java.util.List;

public interface TransactionService {
    void save(Transaction transaction);
    Transaction findById(int id);
    List<Transaction> findByStoreId(int storeId);
    List<Transaction> findByRegionId(int regionId);
}
