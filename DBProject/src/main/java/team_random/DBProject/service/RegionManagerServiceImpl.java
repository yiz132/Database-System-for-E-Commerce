package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.RegionManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.repository.RegionManagerRepository;
import team_random.DBProject.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<String, String>> showAllRegionsTrans() {
        return regionManagerRepository.showAllRegionsTrans();
    }

    @Override
    public List<Map<String, String>> showTransInRegion(int region_manager_id) {
        return regionManagerRepository.showTransInRegion(region_manager_id);
    }

    @Override
    public List<Map<String, String>> reviewAllByStoreManager(int region_manager_id, String search_keyword) {
        List<Map<String,String>> ori = regionManagerRepository.reviewAllByStoreManager(region_manager_id, search_keyword);
        List<Map<String,String>> res = new ArrayList<>();
        for (Map<String,String> map : ori){
            Map<String,String> newMap = new HashMap<>();
            String name = String.valueOf(map.get("name"));
            String total_sales = String.valueOf(map.get("total_sales"));
            String total_profits = String.valueOf(map.get("total_profits"));
            newMap.put("name",name);
            newMap.put("total_sales",total_sales);
            newMap.put("total_profits",total_profits);
            res.add(newMap);
        }
        return res;
    }

    @Override
    public List<Map<String, String>> searchAndSortOfReviewRegions(String search_keyword) {
        List<Map<String,String>> ori = regionManagerRepository.searchAndSortOfReviewRegions(search_keyword);
        List<Map<String,String>> res = new ArrayList<>();
        for (Map<String,String> map : ori){
            Map<String,String> newMap = new HashMap<>();
            String name = String.valueOf(map.get("name"));
            String total_sales = String.valueOf(map.get("total_sales"));
            String total_profits = String.valueOf(map.get("total_profits"));
            newMap.put("name",name);
            newMap.put("total_sales",total_sales);
            newMap.put("total_profits",total_profits);
            res.add(newMap);
        }
        return res;
    }
}
