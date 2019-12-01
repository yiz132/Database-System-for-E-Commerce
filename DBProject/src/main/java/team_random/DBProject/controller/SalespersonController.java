package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Salesperson;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.SalespersonService;
import team_random.DBProject.service.TransactionService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/salesperson")
public class SalespersonController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private SalespersonService salespersonService;

    @PostMapping(path = "/register")
    public @ResponseBody
    Salesperson register(@RequestParam String name, @RequestParam String password, @RequestParam(required = false) String email,
                    @RequestParam String title, @RequestParam int salary){
        if (productService.findByName(name) != null) return null;
        Salesperson person = new Salesperson();
        person.setName(name);
        person.setPassword(password);
        if (email != null) person.setEmail(email);
        person.setTitle(title);
        person.setSalary(salary);
        salespersonService.save(person);
        return person;
    }

    @PostMapping(path = "/signin")
    public @ResponseBody
    Salesperson signin(@RequestParam String name,@RequestParam String password){
        Salesperson salesperson = salespersonService.findByName(name);
        if (salesperson == null) return null;
        if (!salesperson.getPassword().equals(password)) return null;
        return salesperson;
    }

    @PostMapping(path ="/addproduct")
    public @ResponseBody
    Product addProduct(@RequestParam String name, @RequestParam int price,
                      @RequestParam String category, @RequestParam int inventory,
                      @RequestParam(required = false) String description,
                      @RequestParam(required = false) String picture) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setInventory(inventory);
        product.setDescription(description);
        product.setPicture(picture);
        productService.save(product);
        return product;
    }


    //list transactions based on region id
    @PostMapping(path = "/regionmanager/showTransactions")
    public @ResponseBody
    List<Transaction> showRegionTrans(@RequestParam int regionId){
        return null;
    }
}
