package team_random.DBProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StoreManagers")
public class StoreManager {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    private String email;
    private int salary;
    private String storeName;
    private String storeAddress;
    private String storeRegion;

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setStoreName(String storeName){
        this.storeName = storeName;
    }

    public String getStoreName(){
        return this.storeName;
    }

    public void setStoreAddress(String storeAddress){
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress(){
        return this.storeAddress;
    }

    public void setStoreRegion(String regionName){
        this.storeRegion = regionName;
    }

    public String getStoreRegion(){
        return storeRegion;
    }
}
