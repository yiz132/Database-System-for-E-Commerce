package team_random.DBProject.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.HomeCustomerService;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

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
/*
    @PostMapping(path = "/register")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String password){
        HomeCustomer customer = new HomeCustomer();
        customer.setName(name);
        customer.setPassword(password);
        homeCustomerService.save(customer);
        return "Saved";
    }
 */
    @PostMapping(path = "/register")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String password,
                      @RequestParam(required = false) String address,@RequestParam(required = false) String marriage_status,
    @RequestParam(required = false) int age,@RequestParam(required = false) String gender, @RequestParam(required = false) int income){
        HomeCustomer customer = new HomeCustomer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setMarriage_status(marriage_status);
        customer.setAge(age);
        customer.setGender(gender);
        customer.setIncome(income);
        homeCustomerService.save(customer);
        return "Saved";
    }
/*
    @PostMapping(path = "/signin")
    public @ResponseBody String signin(@RequestParam String name,@RequestParam String password){
        HomeCustomer homeCustomer = homeCustomerService.findByName(name);
        if (homeCustomer == null) return "Invalid name or password";
        String password_record = homeCustomer.getPassword();
        if (!password.equals(password_record)) return "Invalid name or password";
        return "signed in";
    }

 */
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

    @PostMapping(path = "/product/checkout")
    public @ResponseBody String checkout(@RequestParam int id, @RequestParam int customer_id,@RequestParam int counts){
        Product product = productService.findById(id);
        int inventory = product.getInventory();
        if (inventory < counts) return "Inventory is not enough, only "+inventory+" remains";
        Transaction transaction = new Transaction();
        transaction.setCustomerId(customer_id);
        Date date = new Date();
        transaction.setDate(date);
        transaction.setCustomerId(counts);
        transactionService.save(transaction);
        return "Successfully purchased";
    }



}
