package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.BusinessCustomer;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.model.Product;
import team_random.DBProject.service.BusinessCustomerService;
import team_random.DBProject.service.ProductService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/Business")
public class BusinessCustomerController {

    @Autowired
    private BusinessCustomerService businessCustomerService;

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/register")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String password,
                      @RequestParam String address, @RequestParam int gross, @RequestParam String category){
        BusinessCustomer customer = new BusinessCustomer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setGross(gross);
        customer.setCategory(category);
        businessCustomerService.save(customer);
        return "Saved";
    }

    @PostMapping(path = "/signin")
    public @ResponseBody String signin(@RequestParam String name,@RequestParam String password){
        BusinessCustomer customer = businessCustomerService.findByName(name);
        if (customer == null) return "Invalid name or password";
        String password_record = customer.getPassword();
        if (!password.equals(password_record)) return "Invalid name or password";
        return "signed in";
    }

    @PostMapping(path ="/addproduct")
    public @ResponseBody String addProduct(@RequestParam String name,@RequestParam int price,
                                           @RequestParam String category,@RequestParam int inventory,
                                           @RequestParam(required = false) String description){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setInventory(inventory);
        product.setDescription(description);
        productService.save(product);
        return "product added";
    }

}
