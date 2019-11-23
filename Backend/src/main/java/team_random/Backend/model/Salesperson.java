package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Salespersons")
public class Salesperson {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String title;
    private String store_id;
    private int salary;
    private String email;
}
