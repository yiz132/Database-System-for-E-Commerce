package team_random.DBProject.service;

import team_random.DBProject.model.BusinessCustomer;

public interface BusinessCustomerService {
    void save(BusinessCustomer customer);
    BusinessCustomer findByName(String name);
    BusinessCustomer findById(int id);
}
