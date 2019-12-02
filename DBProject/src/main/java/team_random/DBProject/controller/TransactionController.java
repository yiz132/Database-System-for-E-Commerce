package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.*;
import team_random.DBProject.service.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ProductService productService;
    @Autowired
    private HomeCustomerService homeCustomerService;
    @Autowired
    private BusinessCustomerService businessCustomerService;
    @Autowired
    private StoreService storeService;

    @PostMapping(path = "/showallproducts")
    public @ResponseBody
    List<Product> showAllProducts(){
        return productService.showAllProducts();
    }

    @PostMapping(path ="/roughsearch")
    public @ResponseBody
    List<Product> prefixSearch(@RequestParam String input){
        return productService.roughSearch(input);
    }

    //Group products by transactions by different category
    @GetMapping(path = "/groupbycategory")
    public @ResponseBody
    Map<String,List<Product>> groupByCategory(){
        return productService.groupByCategory();
        //return productService.sortByCategory;
    }

    //Sort products by selling amount of each product
    @PostMapping(path = "/groupbyname")
    public @ResponseBody
    Map<String,Integer> groupBySale(){
        return productService.groupByName();
    }

    @PostMapping(path = "/showAllStores")
    public @ResponseBody
    List<String> showAllStore(){
        return storeService.findAllNames();
    }
}
