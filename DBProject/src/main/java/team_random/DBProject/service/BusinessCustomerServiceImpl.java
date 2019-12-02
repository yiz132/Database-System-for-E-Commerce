package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.BusinessCustomer;
import team_random.DBProject.repository.BusinessCustomerRepository;

@Service
public class BusinessCustomerServiceImpl implements BusinessCustomerService{
    @Autowired
    private BusinessCustomerRepository businessCustomerRepository;

    @Override
    public void save(BusinessCustomer customer) {
        customer.setPassword(customer.getPassword());
        businessCustomerRepository.save(customer);
    }

    @Override
    public BusinessCustomer findByName(String name) {
        return businessCustomerRepository.findByName(name);
    }

    @Override
    public BusinessCustomer findById(int id) {
        return businessCustomerRepository.findById(id);
    }
}
