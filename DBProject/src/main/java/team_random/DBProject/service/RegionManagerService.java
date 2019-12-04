package team_random.DBProject.service;

import team_random.DBProject.model.RegionManager;
import team_random.DBProject.model.Transaction;

import java.util.List;
import java.util.Map;

public interface RegionManagerService {
    void save(RegionManager mana);
    RegionManager findByName(String name);
    List<Transaction> findByRegionId(int regionId);
    List<Map<String,String>> showAllRegionsTrans();
    List<Map<String, String>> showTransInRegion(int region_manager_id);
}
