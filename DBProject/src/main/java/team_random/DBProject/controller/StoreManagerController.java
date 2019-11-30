package team_random.DBProject.controller;
//https://docs.google.com/document/d/1q0CpZjR2gYz71Hww8ACHI5_CZ5j5N8DrCnI5Ye4E2yg/edit?ts=5dd85412
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.StoreManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.StoreManagerService;
import team_random.DBProject.service.TransactionService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/storemanager")
public class StoreManagerController {
    @Autowired
    private StoreManagerService storeManagerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    String register(@RequestParam String name, @RequestParam String password, @RequestParam String email,
                    @RequestParam int salary, @RequestParam String store_name,
                    @RequestParam String store_address, @RequestParam String store_region){
        StoreManager storeManager = new StoreManager();
        storeManager.setName(name);
        storeManager.setPassword(password);
        storeManager.setEmail(email);
        storeManager.setSalary(salary);
        storeManager.setStoreName(store_name);
        storeManager.setStoreAddress(store_address);
        storeManager.setStoreRegion(store_region);
        storeManagerService.save(storeManager);
        return "Successfully registered as a store manager";
    }
}
