package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.BusinessCustomer;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.service.BusinessCustomerService;

@CrossOrigin
@Controller
@RequestMapping(path = "/dbproject/Business")
public class BusinessCustomerController {

    @Autowired
    private BusinessCustomerService businessCustomerService;

    @PostMapping(path = "/register")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String password,
                      @RequestParam String address, @RequestParam String marriage_status,
                      @RequestParam int age, @RequestParam String gender, @RequestParam int income){
        BusinessCustomer customer = new BusinessCustomer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(address);
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
}
