package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Salesperson;
import team_random.DBProject.model.Store;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.SalespersonService;
import team_random.DBProject.service.StoreService;
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
    private SalespersonService salespersonService;
    @Autowired
    private StoreService storeService;

    @PostMapping(path = "/register")
    public @ResponseBody
    Salesperson register(@RequestParam String name, @RequestParam String password, @RequestParam String email,
                    @RequestParam String title, @RequestParam(required = false) String store_name,@RequestParam int salary){
        if (salespersonService.findByName(name) != null) return null;
        Salesperson person = new Salesperson();
        person.setName(name);
        person.setPassword(password);
        person.setEmail(email);
        person.setTitle(title);
        if (storeService.findByName(store_name) == null) return null;
        Store curr = storeService.findByName(store_name);
        person.setStoreId(curr.getId());
        curr.setNum_salesperson(curr.getNum_salesperson()+1);
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
    Product addProduct(@RequestParam String name, @RequestParam Integer price,
                      @RequestParam String category, @RequestParam Integer inventory,
                      @RequestParam Integer salesperson_id,
                      @RequestParam(required = false) String description,
                      @RequestParam(required = false) String picture){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setSalesperson_id(salesperson_id);
        product.setInventory(inventory);
        product.setDescription(description);
        product.setPicture(picture);
        productService.save(product);
        return product;
    }

    @PostMapping(path ="/updateproduct")
    public @ResponseBody
    Product updateProduct(@RequestParam int pid,
            @RequestParam String name, @RequestParam Integer price,
                          @RequestParam String category, @RequestParam Integer inventory,
                          @RequestParam (required = false) String description, @RequestParam (required = false) String picture){
        Product product = productService.findById(pid);
        if (inventory <= 0) {
            productService.deleteById(pid);
            return product;
        }
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setInventory(inventory);
        if (description != null) product.setDescription(description);
        if (picture != null) product.setDescription(description);
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
