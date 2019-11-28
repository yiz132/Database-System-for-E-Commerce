package team_random.DBProject.controller;
//https://docs.google.com/document/d/1q0CpZjR2gYz71Hww8ACHI5_CZ5j5N8DrCnI5Ye4E2yg/edit?ts=5dd85412
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team_random.DBProject.model.Transaction;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/storemanager")
public class StoreManagerController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/register")
    public @ResponseBody
    String register(){

        return "Successfully registered as a store manager";
    }

}