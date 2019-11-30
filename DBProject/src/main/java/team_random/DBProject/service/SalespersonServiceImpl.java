package team_random.DBProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team_random.DBProject.model.Salesperson;
import team_random.DBProject.repository.SalespersonRepository;

@Service
public class SalespersonServiceImpl implements SalespersonService {
    @Autowired
    SalespersonRepository salespersonRepository;

    @Override
    public void save(Salesperson salesperson) {
        salespersonRepository.save(salesperson);
    }

    @Override
    public Salesperson findByName(String name) {
        return salespersonRepository.findByName(name);
    }
}
