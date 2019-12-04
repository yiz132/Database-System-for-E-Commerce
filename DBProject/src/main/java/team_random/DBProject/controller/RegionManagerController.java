package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.Region;
import team_random.DBProject.model.RegionManager;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.RegionManagerService;
import team_random.DBProject.service.RegionService;
import team_random.DBProject.service.TransactionService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/regionmanager")
public class RegionManagerController {
    @Autowired
    private RegionManagerService regionManagerService;
    @Autowired
    private RegionService regionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    RegionManager register(@RequestParam String name, @RequestParam String password, @RequestParam String email,
                    @RequestParam int salary, @RequestParam String region_name){
        if (regionManagerService.findByName(name) != null) return null;
        RegionManager mana = new RegionManager();
        mana.setName(name);
        mana.setPassword(password);
        mana.setEmail(email);
        mana.setSalary(salary);
        mana.setRegion_name(region_name);
        regionManagerService.save(mana);
        //one region manager to one region
        Region region= new Region();
        region.setManager_id(mana.getId());
        region.setName(region_name);
        regionService.save(region);
        return mana;
    }

    @PostMapping(path = "/signin")
    public @ResponseBody
    RegionManager signin(@RequestParam String name,@RequestParam String password){
        RegionManager manager = regionManagerService.findByName(name);
        if (manager == null) return null;
        if (!manager.getPassword().equals(password)) return null;
        return manager;
    }
    //list transactions based on store id
    @PostMapping(path = "/showtransactions")
    public @ResponseBody
    List<Transaction> showStoreTrans(@RequestParam int regionId){
        return regionManagerService.findByRegionId(regionId);
    }

    @GetMapping(path = "/showtrans/allregions")
    public @ResponseBody
    List<Map<String,String>> showAllRegions(){
        return regionManagerService.showAllRegionsTrans();
    }

    @PostMapping(path = "/showtrans/region")
    public @ResponseBody
    List<Map<String,String>> showTransInRegion(@RequestParam int region_manager_id){
        return regionManagerService.showTransInRegion(region_manager_id);
    }

    @PostMapping(path = "/searchAndSort/stores")
    public @ResponseBody
    List<Map<String,String>> reviewAllByRegionManager(@RequestParam int region_manager_id,
                                                     @RequestParam String search_keyword,
                                                     @RequestParam String sort_keyword){
        List<Map<String,String>> ori = regionManagerService.reviewAllByStoreManager(region_manager_id,search_keyword);
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

    /*@PostMapping(path = "/searchAndSort/regions")
    public @ResponseBody
    List<>

     */
}
