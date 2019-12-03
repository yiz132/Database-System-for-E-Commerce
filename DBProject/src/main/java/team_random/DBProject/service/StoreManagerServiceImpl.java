package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.StoreManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.repository.StoreManagerRepository;
import team_random.DBProject.repository.TransactionRepository;

import java.util.List;

@Service
public class StoreManagerServiceImpl implements StoreManagerService {
    @Autowired
    StoreManagerRepository storeManagerRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void save(StoreManager manager) {
        storeManagerRepository.save(manager);
    }

    @Override
    public StoreManager findByName(String name) {
        return storeManagerRepository.findByName(name);
    }

    @Override
    public List<Transaction> findByStoreId(int storeId) {
        return transactionRepository.findByStoreId(storeId);
    }

    public static void main(String[] args){
        StoreManagerServiceImpl storeManagerService = new StoreManagerServiceImpl();
        List<Transaction> res = storeManagerService.findByStoreId(10);
        System.out.println(res);
    }
}
