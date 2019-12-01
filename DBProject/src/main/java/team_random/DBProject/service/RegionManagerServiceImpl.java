package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.RegionManager;
import team_random.DBProject.repository.RegionManagerRepository;

@Service
public class RegionManagerServiceImpl implements RegionManagerService {
    @Autowired
    RegionManagerRepository regionManagerRepository;

    @Override
    public void save(RegionManager mana) {
        regionManagerRepository.save(mana);
    }

    @Override
    public RegionManager findByName(String name) {
        return regionManagerRepository.findByName(name);
    }
}
