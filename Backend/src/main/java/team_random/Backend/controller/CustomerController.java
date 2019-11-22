package team_random.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team_random.Backend.dao.CustomerDao;

@RestController
public class CustomerController {
    @Autowired
    private CustomerDao dao;

    public void register(){

    }

    public void login(){

    }

    public void logout(){
        
    }
}
