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

    @GetMapping(path = "/showallproducts")
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
    @GetMapping(path = "/groupbycategory/all")
    public @ResponseBody
    Map<String,List<Product>> groupByCategory(){
        return productService.groupByCategory();
        //return productService.sortByCategory;
    }

    //Sort products by selling amount of each product
    @GetMapping(path = "/sortbysales/all")
    public @ResponseBody
    Map<String,Integer> sortBySalesAll(){
        return transactionService.sortBySalesAll();
    }

    //Sort products by total profits of each product
    @GetMapping(path = "/sortbyprofits/all")
    public @ResponseBody
    Map<String,Integer> sortByProfitsAll(){
        return transactionService.sortByProfitsAll();
    }

    //sort transactions by sales in a region
    //return product_name to sales
    @GetMapping(path ="/sortbysales/region")
    public @ResponseBody
    Map<String,Integer> sortBySalesInRegion(@RequestParam int region_id){
        return transactionService.sortBySalesInRegion(region_id);
    }

    //sort transactions by profits in a region
    @GetMapping(path = "/sortbyprofits/region")
    public @ResponseBody
    Map<String,Integer> sortByProfitsInRegion(@RequestParam int region_id){
        return transactionService.sortByProfitsInRegion(region_id);
    }

    //sort transactions by sales in a store
    @GetMapping(path ="/sortbysales/store")
    public @ResponseBody
    Map<String,Integer> sortBySalesInStore(@RequestParam int store_id){
        return transactionService.sortBySalesInStore(store_id);
    }

    //sort transactions by profits in a store
    @GetMapping(path = "/sortbyprofits/store")
    Map<String,Integer> sortByProfitsInStore(@RequestParam int store_id){
        return transactionService.sortByProfitsInStore(store_id);
    }

}
