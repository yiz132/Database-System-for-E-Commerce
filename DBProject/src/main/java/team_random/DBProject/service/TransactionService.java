package team_random.DBProject.service;

import team_random.DBProject.model.Transaction;

public interface TransactionService {
    void save(Transaction transaction);
    Transaction findById(int id);
}
