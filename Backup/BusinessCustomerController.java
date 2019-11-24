package team_random.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import team_random.Backend.model.Customer;
import team_random.Backend.model.HomeCustomer;
import team_random.Backend.model.Login;
import team_random.Backend.service.HomeCustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BusinessCustomerController {
    @Autowired
    public HomeCustomerService homeCustomerService;

    @RequestMapping(value = "/register/business", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("Customer", new Customer());

        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("Customer") HomeCustomer customer){
        homeCustomerService.register(customer);
        return new ModelAndView("Welcome", "First Name", customer.getName());
    }

    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login",new Login());
        return mav;
    }

    @RequestMapping (value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login){
        ModelAndView mav = null;
        Customer customer = homeCustomerService.validateCustomer(login);
        if (customer != null){
            mav = new ModelAndView("Welcome");
            mav.addObject("name", customer.getName());
        }
        else {
            mav = new ModelAndView("login");
            mav.addObject("message","Username or password is wrong!");
        }
        return mav;
    }
}
