package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.repository.HomeCustomerRepository;
import team_random.DBProject.service.HomeCustomerService;

@Controller
@RequestMapping(path = "/dbproject")
public class HomeCustomerController {

    @Autowired
    private HomeCustomerService homeCustomerService;

    @PostMapping(path = "/register")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String password,
                      @RequestParam String address, @RequestParam String marriage_status,
    @RequestParam int age,@RequestParam String gender, @RequestParam int income){
        HomeCustomer customer = new HomeCustomer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setMarriage_status(marriage_status);;
        customer.setAge(age);
        customer.setGender(gender);
        customer.setIncome(income);
        homeCustomerService.save(customer);
        return "Saved";
    }

    @PostMapping(path = "/login/home")
    public @ResponseBody String login(@RequestParam String name,@RequestParam String password){
        HomeCustomer homeCustomer = homeCustomerService.findByName(name);
        if (homeCustomer == null) return "Invalid name or password";
        String password_record = homeCustomer.getPassword();
        if (!password.equals(password_record)) return "Invalid name or password";
        return "logged in";
    }
}
