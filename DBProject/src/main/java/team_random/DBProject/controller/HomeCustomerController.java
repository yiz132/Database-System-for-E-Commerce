package team_random.DBProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.repository.HomeCustomerRepository;

@Controller
@RequestMapping(path = "/dbproject")
public class HomeCustomerController {
    @Autowired
    private HomeCustomerRepository homeCustomerDao;

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
        homeCustomerDao.save(customer);
        return "Saved";
    }

    @RequestMapping(path = "/login/home")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false)String error,@RequestParam(value = "logout", required = false) String logout){
        ModelAndView mav = new ModelAndView();
        if (error != null) {
            mav.addObject("error","Invalid Credentials provided.");
        }
        if (logout != null) {
            mav.addObject("message","Logged out successfully");
        }
        mav.setViewName("loginPage");
        return mav;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<HomeCustomer> getAllHomeCustomers(){
        return homeCustomerDao.findAll();
    }
}
