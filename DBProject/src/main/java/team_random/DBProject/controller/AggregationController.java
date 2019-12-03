package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.*;
import team_random.DBProject.service.*;

import java.util.*;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/aggregation")
public class AggregationController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ProductService productService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private HomeCustomerService homeCustomerService;
    @Autowired
    private BusinessCustomerService businessCustomerService;
    @Autowired
    private SalespersonService salespersonService;
    @Autowired
    private StoreManagerService storeManagerService;
    @Autowired
    private RegionManagerService regionManagerService;

    @PostMapping(path = "/checkregister")
    public @ResponseBody
    String checkRegister(@RequestParam(required = false) String name){
        if (businessCustomerService.findByName(name) != null || homeCustomerService.findByName(name) != null
            || salespersonService.findByName(name) != null|| storeManagerService.findByName(name) != null ||
                regionManagerService.findByName(name) != null) return name;
        return null;
    }

    @GetMapping(path = "/showallstores")
    public @ResponseBody
    List<String> showAllStore(){
        return storeService.findAllNames();
    }

    @GetMapping(path = "/showallregions")
    public @ResponseBody
    List<String> showAllRegion(){
        return regionService.findAllNames();
    }

    @PostMapping(path = "/showallproducts")
    public @ResponseBody
    List<Product> showAllProducts(){
        return productService.showAllProducts();
    }

    @PostMapping(path ="/sortallproducts")
    public @ResponseBody
    List<Product> showHighToLow(@RequestParam String sort, @RequestParam String category){
        //List<Product> ori = showAllProducts();
        List<Product> ori = category.equals("AllCategories")? showAllProducts() : groupByCategory(category);
        if (sort.equals("SortBy")) return ori;
        else if (sort.equals("PriceHighToLow")) {
            ori.sort((o1, o2) -> o2.getPrice() - o1.getPrice());
            return ori;
        }
        else if (sort.equals("PriceLowToHigh")) {
            ori.sort(Comparator.comparingInt(Product::getPrice));
            return ori;
        }
        return ori;
    }

    @PostMapping(path = "/findbypid")
    public @ResponseBody
    Product findByPid(@RequestParam int pid){
        return productService.findById(pid);
    }

    @PostMapping(path = "/findtransbycid")
    public @ResponseBody
    List<Map<String,String>> findTransByCid(int customer_id){
        List<Transaction> trans= transactionService.findAllByCid(customer_id);
        List<Map<String,String>> res = new ArrayList<>();
        for (Transaction tran: trans){
            Map<String,String> map = new HashMap<>();
            int pid = tran.getProductId();
            int num = tran.getNum();
            Product product = findByPid(pid);
            String picture = product.getPicture();
            int price = product.getPrice();
            String total = String.valueOf(price*num);
            String name = product.getName();
            String date = String.valueOf(tran.getDate());
            map.put("picture",picture);
            map.put("name",name);
            map.put("total",total);
            map.put("date",date);
            res.add(map);
        }
        return res;
    }



    @PostMapping(path = "/reviewall/storemanager")
    public @ResponseBody
    List<Map<String,String>> reviewAllByStoreManager(@RequestParam int store_manager_id){
        return storeManagerService.reviewAllByStoreManager(store_manager_id);
    }

    @PostMapping(path = "/checkout")
    public @ResponseBody String checkout(@RequestParam int product_id, @RequestParam int customer_id,@RequestParam int counts){
        Product product = productService.findById(product_id);
        int inventory = product.getInventory();
        if (inventory < counts) return "Inventory is not enough, only "+inventory+" remains";
        int total_price = product.getPrice()*counts;
        if (homeCustomerService.findById(customer_id) != null){
            HomeCustomer customer = homeCustomerService.findById(customer_id);
            int rem = customer.getAccount();
            if (rem < total_price) return "Account balance not enough";
            customer.setAccount(rem-total_price);
            homeCustomerService.save(customer);
        }
        else if (businessCustomerService.findById(customer_id) != null){
            BusinessCustomer customer = businessCustomerService.findById(customer_id);
            int rem = customer.getAccount();
            if (rem < total_price) return "Account balance not enough";
            customer.setAccount(rem-total_price);
            businessCustomerService.save(customer);
        }
        Transaction transaction = new Transaction();
        transaction.setCustomerId(customer_id);
        transaction.setProductId(product_id);
        transaction.setNum(counts);
        Date date = new Date();
        transaction.setDate(date);
        transactionService.save(transaction);
        product.setInventory((inventory-counts));
        productService.save(product);
        if (inventory == counts) productService.deleteById(product_id);
        return String.valueOf(customer_id);
    }

    @PostMapping(path = "/showallproducts/salesperson")
    public @ResponseBody
    List<Product> showProductsOfSalesperson(@RequestParam int id){
        return productService.findBySalespersonId(id);
    }

    @PostMapping(path ="/roughsearch")
    public @ResponseBody
    List<Product> roughSearch(@RequestParam String input){
        return productService.roughSearch(input);
    }

    //Group products by transactions by different category
    @PostMapping(path = "/groupbycategory/all")
    public @ResponseBody
    List<Product> groupByCategory(@RequestParam String category){
        return productService.groupByCategory(category);
        //return productService.sortByCategory;
    }

    //Sort products by selling amount of each product
    @GetMapping(path = "/sortbysales/all")
    public @ResponseBody
    List<Map<String,Integer>> sortBySalesAll(){
        return transactionService.sortBySalesAll();
    }

    //Sort products by total profits of each product
    @PostMapping(path = "/sortbyprofits/all")
    public @ResponseBody
    List<Map<String,Integer>> sortByProfitsAll(){
        return transactionService.sortByProfitsAll();
    }

    //sort transactions by sales in a region
    //return product_name to sales
    @PostMapping(path ="/sortbysales/region")
    public @ResponseBody
    List<Map<String,Integer>> sortBySalesInRegion(@RequestParam int region_id){
        return transactionService.sortBySalesInRegion(region_id);
    }

    //sort transactions by profits in a region
    @PostMapping(path = "/sortbyprofits/region")
    public @ResponseBody
    List<Map<String,Integer>> sortByProfitsInRegion(@RequestParam int region_id){
        return transactionService.sortByProfitsInRegion(region_id);
    }

    //sort transactions by sales in a store
    @PostMapping(path ="/sortbysales/store")
    public @ResponseBody
    List<Map<String,Integer>> sortBySalesInStore(@RequestParam int store_id){
        return transactionService.sortBySalesInStore(store_id);
    }

    //sort transactions by profits in a store
    @GetMapping(path = "/sortbyprofits/store")
    public @ResponseBody
    List<Map<String,Integer>> sortByProfitsInStore(@RequestParam int store_id){
        return transactionService.sortByProfitsInStore(store_id);
    }

}
