package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.repository.TransactionRepository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    public Map<String, Integer> sortBySalesAll() {
        return transactionRepository.groupTransByName();
    }

    @Override
    public Map<String, Integer> sortByProfitsAll() {
        return transactionRepository.sortTransByProfits();
    }

    @Override
    public Map<String,Integer> sortBySalesInRegion(int region_id) {
        return transactionRepository.groupTransByNameInRegion(region_id);
    }

    @Override
    public Map<String, Integer> sortByProfitsInRegion(int region_id) {
        return transactionRepository.sortTransByProfitsInRegion(region_id);
    }

    @Override
    public Map<String, Integer> sortBySalesInStore(int store_id) {
        return transactionRepository.groupTransByNameInStore(store_id);
    }

    @Override
    public Map<String, Integer> sortByProfitsInStore(int store_id) {
        return transactionRepository.sortTransByProfitsInStore(store_id);
    }

    @Override
    public List<Transaction> findAllByCid(int cid) {
        return transactionRepository.findAllByCid(cid);
    }
}
