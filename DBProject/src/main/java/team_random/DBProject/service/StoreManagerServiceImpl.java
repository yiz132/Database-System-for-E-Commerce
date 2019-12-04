package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.StoreManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.repository.StoreManagerRepository;
import team_random.DBProject.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreManagerServiceImpl implements StoreManagerService {
    @Autowired
    StoreManagerRepository storeManagerRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ProductService productService;

    @Override
    public void save(StoreManager manager) {
        storeManagerRepository.save(manager);
    }

    @Override
    public StoreManager findById(int store_manager_id) {
        return storeManagerRepository.findById(store_manager_id);
    }

    @Override
    public StoreManager findByName(String name) {
        return storeManagerRepository.findByName(name);
    }

    @Override
    public List<Transaction> findByStoreId(int storeId) {
        return transactionRepository.findByStoreId(storeId);
    }

    /**
     *
     * @param store_mana_id
     * @return
     */
    @Override
    public List<Map<String, String>> reviewAllByStoreManager(int store_mana_id) {
        List<Map<String,String>> ori = storeManagerRepository.reviewAllByStoreManagerId(store_mana_id);
        List<Map<String,String>> res = new ArrayList<>();
        for (Map<String,String> map : ori){
            Map<String,String> newMap = new HashMap<>();
            String product_name = map.get("name");
            String total_sales = String.valueOf(map.get("total_sales"));
            String total_profits = String.valueOf(map.get("total_profits"));
            Product product = productService.findByName(product_name);
            String picture = product.getPicture();
            String inventory = String.valueOf(product.getInventory());
            newMap.put("name",product_name);
            newMap.put("total_sales",total_sales);
            newMap.put("total_profits",total_profits);
            newMap.put("picture",picture);
            newMap.put("inventory",inventory);
            res.add(newMap);
        }
        return res;
    }

    @Override
    public List<Map<String, String>> searchProductsByKeywords(int id, String search_keyword) {
        List<Map<String,String>> res = new ArrayList<>();
        //only contains name, total_sales,total_profits
        List<Map<String,String>> raw = storeManagerRepository.searchProductsByKeywords(id,search_keyword);
        for (Map<String,String> map : raw){
            Map<String,String> newMap = new HashMap<>();
            String product_name = map.get("name");
            String total_sales = String.valueOf(map.get("total_sales"));
            String total_profits = String.valueOf(map.get("total_profits"));
            Product product = productService.findByName(product_name);
            String picture = product.getPicture();
            String inventory = String.valueOf(product.getInventory());
            newMap.put("name",product_name);
            newMap.put("total_sales",total_sales);
            newMap.put("total_profits",total_profits);
            newMap.put("picture",picture);
            newMap.put("inventory",inventory);
            res.add(newMap);
        }
        return res;
    }

    public static void main(String[] args){
        StoreManagerServiceImpl storeManagerService = new StoreManagerServiceImpl();
        List<Transaction> res = storeManagerService.findByStoreId(10);
        System.out.println(res);
    }
}
