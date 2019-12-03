package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.BusinessCustomer;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.BusinessCustomerService;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

import java.util.Date;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/business")
public class BusinessCustomerController {

    @Autowired
    private BusinessCustomerService businessCustomerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    BusinessCustomer addNewUser(@RequestParam String name, @RequestParam String password,
                      @RequestParam String address, @RequestParam int gross, @RequestParam String category){
        if (businessCustomerService.findByName(name) != null) return null;
        BusinessCustomer customer = new BusinessCustomer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setGross(gross);
        customer.setCategory(category);
        businessCustomerService.save(customer);
        return customer;
    }

    @PostMapping(path = "/checkregister")
    public @ResponseBody
    String checkRegister(@RequestParam(required = false) String input){
        if (businessCustomerService.findByName(input) != null) return input;
        return null;
    }

    @PostMapping(path = "/signin")
    public @ResponseBody BusinessCustomer signin(@RequestParam String name,@RequestParam String password){
        BusinessCustomer customer = businessCustomerService.findByName(name);
        if (customer == null) return null;
        String password_record = customer.getPassword();
        if (!password.equals(password_record)) return null;
        return customer;
    }

    @PostMapping(path = "/product/search")
    public @ResponseBody
    Product searchProduct(@RequestParam String name){
        return productService.findByName(name);
    }

    @PostMapping(path = "/checkout")
    public @ResponseBody String checkout(@RequestParam int product_id, @RequestParam int customer_id,@RequestParam int counts){
        Product product = productService.findById(product_id);
        BusinessCustomer customer = businessCustomerService.findById(customer_id);
        int inventory = product.getInventory();
        if (inventory < counts) return "Inventory is not enough, only "+inventory+" remains";

        int total_price = product.getPrice()*counts;
        int rem = customer.getAccount();
        if (rem < total_price) return "Account balance not enough";
        customer.setAccount(rem-total_price);
        Transaction transaction = new Transaction();
        transaction.setCustomerId(customer_id);
        Date date = new Date();
        transaction.setProductId(product_id);
        transaction.setNum(counts);
        transaction.setDate(date);
        transaction.setCustomerId(counts);
        product.setInventory((inventory-counts));
        transactionService.save(transaction);
        productService.save(product);
        businessCustomerService.save(customer);
        if (inventory == counts) productService.deleteById(product_id);
        return "Successfully purchased";
    }
}
