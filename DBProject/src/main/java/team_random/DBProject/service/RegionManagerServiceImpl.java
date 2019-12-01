package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.RegionManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.repository.RegionManagerRepository;
import team_random.DBProject.repository.TransactionRepository;

import java.util.List;

@Service
public class RegionManagerServiceImpl implements RegionManagerService {
    @Autowired
    RegionManagerRepository regionManagerRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void save(RegionManager mana) {
        regionManagerRepository.save(mana);
    }

    @Override
    public RegionManager findByName(String name) {
        return regionManagerRepository.findByName(name);
    }

    @Override
    public List<Transaction> findByRegionId(int regionId) {
        return transactionRepository.findByRegionId(regionId);
    }
}