package team_random.DBProject.service;

import team_random.DBProject.model.HomeCustomer;

import java.util.List;
import java.util.Map;

public interface HomeCustomerService {
    void save(HomeCustomer homeCustomer);

    HomeCustomer findByName(String name);

    HomeCustomer findById(int id);

}
