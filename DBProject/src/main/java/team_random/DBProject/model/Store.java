package team_random.DBProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stores")
public class Store {
    @Id
    @GeneratedValue
    private int id;
    private int rid; //region id;
    private String address;
    private int num_salesperson;
    private int manager_id;


    public int getId(){
        return this.id;
    }

    public void setRegionId(int rid){
        this.rid = rid;
    }

    public int getRid(){
        return this.rid;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setNum_salesperson(int num){
        this.num_salesperson = num;
    }

    public int getNum_salesperson(){
        return num_salesperson;
    }

    public void setManager_id(int mid){
        this.manager_id = mid;
    }

    public int getManager_id(){
        return manager_id;
    }
}
