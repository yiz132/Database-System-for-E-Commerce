package team_random.Backend.model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Customer {
    @Id
    @GeneratedValue
    protected int id;
    protected String name;
    protected String password;
    protected String address;

    @Enumerated
    @Column(name = "role")
    private Customer_Role role;

    public Customer(){

    }

    public void setId(int id){this.id = id;}

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getId(){return id;}

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
