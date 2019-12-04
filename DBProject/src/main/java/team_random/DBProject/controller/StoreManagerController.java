package team_random.DBProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Store;
import team_random.DBProject.model.StoreManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.*;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/storemanager")
public class StoreManagerController {
    @Autowired
    private StoreManagerService storeManagerService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private RegionService regionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    StoreManager register(@RequestParam String name, @RequestParam String password, @RequestParam String email,
                    @RequestParam int salary, @RequestParam String store_name,
                    @RequestParam String store_address, @RequestParam String store_region){
        if (storeManagerService.findByName(name) != null) return null;
        //if store_region is invalid
        if (regionService.findByName(store_region) == null) return null;
        StoreManager storeManager = new StoreManager();
        storeManager.setName(name);
        storeManager.setPassword(password);
        storeManager.setEmail(email);
        storeManager.setSalary(salary);
        storeManager.setStoreName(store_name);
        storeManager.setStoreAddress(store_address);
        storeManager.setStoreRegion(store_region);
        storeManagerService.save(storeManager);
        Store store = new Store();
        store.setName(store_name);
        store.setNum_salesperson(0);
        store.setAddress(store_address);
        store.setManager_id(storeManager.getId());
        store.setRegionId(regionService.findByName(store_region).getId());
        storeService.save(store);
        return storeManager;
    }

    @PostMapping(path = "/signin")
    public @ResponseBody
    StoreManager signin(@RequestParam String name,@RequestParam String password){
        StoreManager manager = storeManagerService.findByName(name);
        if (manager == null) return null;
        if (!manager.getPassword().equals(password)) return null;
        return manager;
    }

    //list transactions based on store id
    @PostMapping(path = "/showTransactions")
    public @ResponseBody
    List<Transaction> showStoreTrans(@RequestParam int storeId){
        return storeManagerService.findByStoreId(storeId);
    }

    @PostMapping(path = "/searchandsort")
    public @ResponseBody
    List<Map<String,String>> searchAndSort(@RequestParam int id, @RequestParam String search_keyword,
                                           @RequestParam String sort_keyword){
        List<Map<String,String>> ori = storeManagerService.searchProductsByKeywords(id,search_keyword);
        if (sort_keyword.equals("ProfitHighToLow")){
            ori.sort( (p1,p2) -> Integer.parseInt(p2.get("total_profits")) - Integer.parseInt(p1.get("total_profits")));
        }
        else if (sort_keyword.equals("ProfitLowToHigh")){
            ori.sort(Comparator.comparingInt(p -> Integer.parseInt(p.get("total_profits"))));

        }
        else if (sort_keyword.equals("SalesHighToLow")){
            ori.sort( (p1,p2) -> Integer.parseInt(p2.get("total_sales")) - Integer.parseInt(p1.get("total_sales")));
        }
        else if (sort_keyword.equals("SalesLowToHigh")){
            ori.sort(Comparator.comparingInt(p -> Integer.parseInt(p.get("total_sales"))));
        }
        return ori;
    }

}
