package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Region;
import team_random.DBProject.repository.RegionRepository;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;
    @Override
    public void save(Region region) {
        regionRepository.save(region);
    }

    @Override
    public Region findByName(String name) {
        return regionRepository.findByName(name);
    }

    @Override
    public List<String> findAllNames() {
        return regionRepository.findAllNames();
    }

    @Override
    public Region findById(int id) {
        return regionRepository.findById(id);
    }
}
