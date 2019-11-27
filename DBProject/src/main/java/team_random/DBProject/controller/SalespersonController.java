package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

import java.io.File;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/salesperson")
public class SalespersonController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping(path ="/addproduct")
    public @ResponseBody
    String addProduct(@RequestParam String name, @RequestParam int price,
                      @RequestParam String category, @RequestParam int inventory,
                      @RequestParam(required = false) String description,
                      @RequestParam(required = false) File picture) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setInventory(inventory);
        product.setDescription(description);
        product.setPicture(picture);
        productService.save(product);
        return "product added";
    }

    //list transactions based on store id
    @PostMapping(path = "/storemanager/showTransactions")
    public @ResponseBody
    List<Transaction> showStoreTrans(@RequestParam int storeId){
        return transactionService.findByStoreId(storeId);
    }

    //list transactions based on region id
    @PostMapping(path = "/regionmanager/showTransactions")
    public @ResponseBody
    List<Transaction> showRegionTrans(@RequestParam int regionId){
        return transactionService.findByRegionId(regionId);
    }
}
