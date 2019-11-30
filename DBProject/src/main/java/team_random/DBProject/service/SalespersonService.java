package team_random.DBProject.service;

import team_random.DBProject.model.Salesperson;

public interface SalespersonService {
    public void save(Salesperson salesperson);
    public Salesperson findByName(String name);
}
