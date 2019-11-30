package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.StoreManager;
import team_random.DBProject.repository.StoreManagerRepository;

@Service
public class StoreManagerServiceImpl implements StoreManagerService {
    @Autowired
    StoreManagerRepository storeManagerRepository;

    @Override
    public void save(StoreManager manager) {
        storeManagerRepository.save(manager);
    }

    @Override
    public StoreManager findByName(String name) {
        return storeManagerRepository.findByName(name);
    }
}
