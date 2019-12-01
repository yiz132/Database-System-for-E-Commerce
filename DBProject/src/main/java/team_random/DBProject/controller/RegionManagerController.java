package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.RegionManager;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.RegionManagerService;
import team_random.DBProject.service.TransactionService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/regionmanager")
public class RegionManagerController {
    @Autowired
    private RegionManagerService regionManagerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    String register(@RequestParam String name, @RequestParam String password, @RequestParam String email,
                    @RequestParam int salary, @RequestParam String region_name){
        RegionManager mana = new RegionManager();
        mana.setName(name);
        mana.setPassword(password);
        mana.setEmail(email);
        mana.setSalary(salary);
        mana.setRegion_name(region_name);
        regionManagerService.save(mana);
        return "Successfully registered as a region manager";
    }


}
