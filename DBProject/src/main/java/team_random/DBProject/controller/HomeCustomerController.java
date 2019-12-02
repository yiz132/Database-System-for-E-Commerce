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
}
