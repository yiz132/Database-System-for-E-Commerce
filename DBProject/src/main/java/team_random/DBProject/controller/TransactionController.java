package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team_random.DBProject.model.Product;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ProductService productService;


    //Sort the products by transactions num with different category
    @PostMapping(path = "/sortbycategory")
    public @ResponseBody
    List<Product> sortByCategory(){
        return null;
        //return productService.sortByCategory;
    }
}
