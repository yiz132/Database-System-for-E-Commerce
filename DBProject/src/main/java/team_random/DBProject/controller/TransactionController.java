package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.*;
import team_random.DBProject.service.BusinessCustomerService;
import team_random.DBProject.service.HomeCustomerService;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

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

    @PostMapping(path = "/product/checkout")
    public @ResponseBody String checkout(@RequestParam int product_id, @RequestParam int customer_id,@RequestParam int counts){
        Product product = productService.findById(product_id);
        int inventory = product.getInventory();
        if (inventory < counts) return "Inventory is not enough, only "+inventory+" remains";
        if (inventory == counts) productService.deleteById(product_id);
        int total_price = product.getPrice()*counts;
        if(homeCustomerService.findById(customer_id)!= null) {
            HomeCustomer customer = homeCustomerService.findById(customer_id);
            int rem = customer.getAccount();
            if (rem < total_price) return "Account balance not enough";
            customer.setAccount(rem-total_price);
        }
        else if (businessCustomerService.findById(customer_id) != null){
            BusinessCustomer customer = businessCustomerService.findById(customer_id);
            int rem = customer.getAccount();
            if (rem < total_price) return "Account balance not enough";
            customer.setAccount(rem-total_price);
        }
        Transaction transaction = new Transaction();
        transaction.setCustomerId(customer_id);
        Date date = new Date();
        transaction.setDate(date);
        transaction.setCustomerId(counts);
        transactionService.save(transaction);
        return "Successfully purchased";
    }

    //Group products by transactions by different category
    @GetMapping(path = "/sortbycategory")
    public @ResponseBody
    Map<String,List<Product>> sortByCategory(){
        return productService.groupByCategory();
        //return productService.sortByCategory;
    }

    //Sort products by selling amount of each product
    @PostMapping(path = "/sortbysale")
    public @ResponseBody
    List<Product> sortBySale(){
        return productService.sortBySale();
    }

}
