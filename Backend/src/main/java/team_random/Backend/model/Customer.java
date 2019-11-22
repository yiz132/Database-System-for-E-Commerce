package team_random.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Customer")

public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;

    public Customer(){

    }

    public Customer(int id, String name, String address){

    }
}
