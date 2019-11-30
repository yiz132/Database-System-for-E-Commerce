package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import team_random.DBProject.service.ProductService;
import team_random.DBProject.service.TransactionService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/regionmanager")
public class RegionManagerController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;



}
