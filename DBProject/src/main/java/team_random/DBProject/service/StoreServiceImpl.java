package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Store;
import team_random.DBProject.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    @Override
    public void save(Store store) {
        storeRepository.save(store);
    }

    @Override
    public Store findById(int id) {
        return storeRepository.findById(id);
    }
}
