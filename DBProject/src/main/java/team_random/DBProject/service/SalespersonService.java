package team_random.DBProject.service;

import team_random.DBProject.model.Salesperson;

public interface SalespersonService {
    void save(Salesperson salesperson);
    Salesperson findByName(String name);
}
