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
    private String password;
    private String address;

    public Customer(){

    }

    public Customer(int id, String name, String password, String address){
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getName(){
        return this.name;
    }
    
    public String getPassword(){
        return this.password;
    }

    public String getAddress(){
        return this.address;
    }
}
