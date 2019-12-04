package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.HomeCustomer;
import team_random.DBProject.repository.HomeCustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeCustomerServiceImpl implements HomeCustomerService {
    @Autowired
    private HomeCustomerRepository homeCustomerRepository;

    @Override
    public void save(HomeCustomer homeCustomer) {
        homeCustomer.setPassword(homeCustomer.getPassword());
        homeCustomerRepository.save(homeCustomer);
    }

    @Override
    public HomeCustomer findByName(String name) {
        return homeCustomerRepository.findByName(name);
    }

    @Override
    public HomeCustomer findById(int id) {
        return homeCustomerRepository.findById(id);
    }
}
