package team_random.DBProject.model;

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
    private String password;
    private String email;
    private String title;
    private int pid; //product id
    private int sid; //store id
    private int salary;

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
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
        return this.email;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setProductId(int pid){
        this.pid = pid;
    }

    public int getProductId(){
        return pid;
    }

    public void setStoreId(int sid){
        this.sid = sid;
    }

    public int getStoreId(){
        return sid;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }
}
