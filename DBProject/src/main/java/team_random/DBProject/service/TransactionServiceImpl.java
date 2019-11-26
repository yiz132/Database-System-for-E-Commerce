package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction findById(int id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> findByStoreId(int storeId) {
        return transactionRepository.findByStoreId(storeId);
    }

    @Override
    public List<Transaction> findByRegionId(int regionId) {
        return transactionRepository.findByRegionId(regionId);
    }
}
