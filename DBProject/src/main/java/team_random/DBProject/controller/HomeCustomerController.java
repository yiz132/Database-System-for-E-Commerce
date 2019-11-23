package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.repository.HomeCustomerRepository;

@Controller
@RequestMapping(path = "/dbproject")
public class HomeCustomerController {
    @Autowired
    private HomeCustomerRepository homeCustomerDao;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String password){
        HomeCustomer customer = new HomeCustomer();
        customer.setName(name);
        customer.setPassword(password);
        homeCustomerDao.save(customer);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<HomeCustomer> getAllHomeCustomers(){
        return homeCustomerDao.findAll();
    }
}
