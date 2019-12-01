package team_random.DBProject.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Region_Managers")
public class RegionManager {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    private String email;
    private int salary;
    private String region_name;

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

    public void setRegion_name(String rName){
        region_name = rName;
    }

    public String getRegion_name(){
        return region_name;
    }

}
