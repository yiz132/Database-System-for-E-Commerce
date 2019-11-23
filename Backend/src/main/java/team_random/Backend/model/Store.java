package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Stores")
public class Store {
    private int id;
    private int num_salesperson;
    private int regionId;
    private String address;
    private Salesperson manager;
}
