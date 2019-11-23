package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Regions")
public class Region {


    private int id;
    private int store_id;
    private String name;
    private Salesperson manager;
}
