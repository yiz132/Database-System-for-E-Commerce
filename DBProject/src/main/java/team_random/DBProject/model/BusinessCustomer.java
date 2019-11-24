package team_random.DBProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Business_Customers")
public class BusinessCustomer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    private String address;
    private int account;
    private int gross;
    private String category;

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setAccount(int account){
        this.account = account;
    }

    public int getAccount(){
        return this.account;
    }

    public void setGross(int gross){
        this.gross = gross;
    }

    public int getGross(){
        return gross;
    }

    public void setCategory(String cate){
        this.category = cate;
    }

    public String getCategory(){
        return this.category;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
