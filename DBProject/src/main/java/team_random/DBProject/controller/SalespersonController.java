package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.Product;
import team_random.DBProject.service.ProductService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/salesperson")
public class SalespersonController {
    @Autowired
    private ProductService productService;

    @PostMapping(path ="/addproduct")
    public @ResponseBody
    String addProduct(@RequestParam String name, @RequestParam int price,
                      @RequestParam String category, @RequestParam int inventory,
                      @RequestParam(required = false) String description) {
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
