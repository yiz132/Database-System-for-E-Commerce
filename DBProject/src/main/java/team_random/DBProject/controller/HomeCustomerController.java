package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.BusinessCustomer;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.HomeCustomerService;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

import java.util.Date;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/home")
public class HomeCustomerController {

    @Autowired
    private HomeCustomerService homeCustomerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    HomeCustomer addNewUser(@RequestParam String name, @RequestParam String password,
                            @RequestParam(required = false) String address,@RequestParam(required = false) String marriage_status,
                            @RequestParam(required = false) int age,@RequestParam(required = false) String gender,
                            @RequestParam(required = false) int income, @RequestParam(required = false) int account){
        if (homeCustomerService.findByName(name) != null) return null;
        HomeCustomer customer = new HomeCustomer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setMarriage_status(marriage_status);
        customer.setAge(age);
        customer.setGender(gender);
        customer.setIncome(income);
        customer.setAccount(account);
        homeCustomerService.save(customer);
        return customer;
    }


    @PostMapping(path = "/checkregister")
    public @ResponseBody
    String checkRegister(@RequestParam(required = false) String input){
        if (homeCustomerService.findByName(input) != null) return input;
        return null;
    }

    @PostMapping(path = "/signin")
    public @ResponseBody
    HomeCustomer signin(@RequestParam String name, @RequestParam String password){
        HomeCustomer homeCustomer = homeCustomerService.findByName(name);
        if (homeCustomer == null) return null;
        String password_record = homeCustomer.getPassword();
        if (!password.equals(password_record)) return null;
        return homeCustomer;
    }

    @PostMapping(path = "/product/search")
    public @ResponseBody
    Product searchProduct(@RequestParam String name){
        return productService.findByName(name);
    }

    @PostMapping(path = "/checkout")
    public @ResponseBody String checkout(@RequestParam int product_id, @RequestParam int customer_id,@RequestParam int counts){
        Product product = productService.findById(product_id);
        int inventory = product.getInventory();
        if (inventory < counts) return "Inventory is not enough, only "+inventory+" remains";
        int total_price = product.getPrice()*counts;
        HomeCustomer customer = homeCustomerService.findById(customer_id);
        int rem = customer.getAccount();
        if (rem < total_price) return "Account balance not enough";
        customer.setAccount(rem-total_price);
        Transaction transaction = new Transaction();
        transaction.setCustomerId(customer_id);
        transaction.setProductId(product_id);
        transaction.setNum(counts);
        Date date = new Date();
        transaction.setDate(date);
        transaction.setCustomerId(counts);
        transactionService.save(transaction);
        product.setInventory((inventory-counts));
        productService.save(product);
        homeCustomerService.save(customer);
        if (inventory == counts) productService.deleteById(product_id);
        return "Successfully purchased";
    }
}
